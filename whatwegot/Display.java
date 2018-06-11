import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
public class Display extends JFrame
{
	Font font = new Font("ComicSans", Font.PLAIN, 24);
    ButtonGroup groupAt = new ButtonGroup();
    ButtonGroup groupAb = new ButtonGroup();
    Player active;
    Environment actEnv;
    public static JMenuBar atBar = new JMenuBar();
    public static JMenuBar abBar = new JMenuBar();
    public static JMenuBar tarBar = new JMenuBar();
    public static JMenuBar allBar = new JMenuBar();
    JMenu atMenu = new JMenu("Attack");
    JMenu abMenu = new JMenu("Ability casting");
    JMenu tarMenu = new JMenu("Targeting");
    JMenu allMenu = new JMenu("All targeting");
    JFrame screen;
    Canvas panel;
    JButton attack = new JButton("Attack");
    JButton useAb = new JButton("Use Ability");
    JButton items = new JButton("Items");
    public Display(Player p, Environment e)
    {
        active = p;
        actEnv = e;
        screen = new JFrame("Fight Game");
        panel = new Canvas(active, actEnv, this);
        screen.add(panel);
        for(int i = 0; i < p.getAbilities().size(); i++)
        {
            JButton btn = p.getAbilities().get(i).getTrigger();
            groupAb.add(btn);
            abBar.add(btn);
            btn.addActionListener(new ButtonListener(p, e));
        }

        if(p.isHealer())
        {
            for(int i = 0; i < e.getPlayers().size(); i++)
            {
                JButton btn = new JButton(e.getPlayers().get(i).getName());
                groupAt.add(btn);
                atBar.add(btn);
                btn.addActionListener(new AuxiliaryButtonListener(p, e));
            }
        }
        else
        {
            for(int i = 0; i < e.getEnemies().size(); i++)
            {
                JButton btn = new JButton(e.getEnemies().get(i).getName());
                groupAt.add(btn);
                atBar.add(btn);
                btn.addActionListener(new AuxiliaryButtonListener(p, e));
            }
        }
        JButton all = new JButton("All");
        allBar.add(all);
    }

    public void run()
    {

        atBar.add(atMenu);
        abBar.add(abMenu);
        tarBar.add(tarMenu);
        allBar.add(allMenu);
        attack.addActionListener(new ButtonListener(active, actEnv));
        useAb.addActionListener(new ButtonListener(active, actEnv));
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(tarBar, BorderLayout.SOUTH);
        screen.setContentPane(panel);
        screen.setPreferredSize(new Dimension(1600, 900));
        screen.add(attack);
        screen.add(useAb);
        screen.add(items);
        screen.add(atBar);
        screen.add(abBar);
        screen.add(tarBar);
        screen.add(allBar);
        atBar.setVisible(false);
        abBar.setVisible(false);
        tarBar.setVisible(false);
        allBar.setVisible(false);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
        screen.pack();
    }
    public static void main(String[] args)
    {
        Dragon dragon = new Dragon(2);
        Fighter ulfeen= new Fighter("Ulfeen", new ActorClass(0),2, new BufferedImage(1,2,3));
        ArrayList<Player> allPlayers = new ArrayList<Player>();
        ArrayList<Enemy> allEnemies = new ArrayList<Enemy>();
        allPlayers.add(ulfeen);
        allEnemies.add(dragon);
        boolean canMoveOn = false;
        Environment demoEnv = new Environment(ulfeen, allPlayers, allEnemies);
        demoEnv.addActor(ulfeen);
        Display d = new Display(ulfeen, demoEnv);
        while(ulfeen.getHealth() > 0 && dragon.getHealth() > 0)
        {
            d.run();
            dragon.act(demoEnv);
            int i = dragon.getHealth();
            while(!canMoveOn)
            {
            	if(dragon.getHealth() < i)
            		break;
            }
        }
        if(ulfeen.getHealth() <= 0)
        {
            System.out.println("You lose");
        }
        else
        {
            System.out.println("You win");
        }
}
class Canvas extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage image1;
    BufferedImage ulfeen;
    ArrayList<Actor> playerStats;
    ArrayList<Actor> enemyStats;
    Player player;
    Environment e;
    Display disp;
    public Canvas(Player p, Environment env, Display d)
    {
        disp = d;
        player = p;
        e = env;
        playerStats = env.getPlayers();
        enemyStats = (ArrayList<Actor>)env.getEnemies();
        try
        {
            image1 = ImageIO.read(new File("src//mullen.jpg"));
            ulfeen = ImageIO.read(new File("src//betterulf.jpg"));
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        setBackground(new Color(0, 0, 0));
        setFocusable(true);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g.setFont(font);
        int y = 800;
        	g.drawString(player.getName() + ": ", 1075, y);
        	g.setColor(Color.white);
            g.drawString("Health: " + Integer.toString(player.getHealth()) + "/" + Integer.toString(player.getMaxHealth()) + " | Mana: " + Integer.toString(player.currentMana) + "/" + Integer.toString(player.maxMana),1175, y );

        y = 800;
        for(Actor a: enemyStats)
        {
        	g.setColor(Color.red);
        	g.drawString(a.getName() + ": ", 50, y);
        	g.setColor(Color.white);
            g.drawString("Health: " + Integer.toString(a.getHealth()) + " / " + Integer.toString(a.getMaxHealth()) + " | Mana: " + Integer.toString(a.currentMana) + "/" + Integer.toString(a.maxMana),150, y);
        }
        g.drawImage(image1, 50,100,null);
        g.drawImage(ulfeen, 1000,100,null);
        this.repaint();
    }



}
}
