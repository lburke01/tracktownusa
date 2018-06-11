import javafx.scene.control.RadioButton;

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
    Environment dispEnv;
    ButtonGroup groupAt = new ButtonGroup();
    ButtonGroup groupAb = new ButtonGroup();
    public static JMenuBar atBar = new JMenuBar();
    public static JMenuBar abBar = new JMenuBar();
    public static JMenuBar tarBar = new JMenuBar();
    public static JMenuBar allBar = new JMenuBar();
    JMenu atMenu = new JMenu("Attack");
    JMenu abMenu = new JMenu("Ability casting");
    JMenu tarMenu = new JMenu("Targeting");
    JMenu allMenu = new JMenu("All targeting");
    JFrame screen = new JFrame("Fight Game");
    Canvas panel;
    JButton attack = new JButton("Attack");
    JButton useAb = new JButton("Use Ability");
    JButton items = new JButton("Items");
    public Display(Player p, Environment e, Party team)
    {
        dispEnv = e;
        panel = new Canvas(p, e);
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

    public void run(Player p, Environment e)
    {
        atBar.add(atMenu);
        abBar.add(abMenu);
        tarBar.add(tarMenu);
        allBar.add(allMenu);
        attack.addActionListener(new ButtonListener(p, e));
        useAb.addActionListener(new ButtonListener(p, e));
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.add(panel);
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

}
class Canvas extends JPanel
{
    private Rectangle scoopnum;
    BufferedImage image1;
    BufferedImage ulfeen;
    BufferedImage corvi;
    BufferedImage luke;
    ArrayList<Actor> playerStats;
    ArrayList<Actor> enemyStats;
    public Canvas(Player p, Environment env)
    {
        playerStats = (ArrayList<Actor>)env.getPlayers();
        enemyStats = (ArrayList<Actor>)env.getEnemies();
        scoopnum = new Rectangle(25, 25, 25, 25);
        try
        {
            image1 = ImageIO.read(new File("src//souptime.jpg"));
            luke = ImageIO.read(new File("src//lukusburkus.jpg"));
            corvi = ImageIO.read(new File("src//corbleel.jpg"));
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
        int y = 800;
        for(Actor a: playerStats)
        {
            g.drawString(a.getName() + ": Health: " + Integer.toString(a.getHealth()) + "/" + Integer.toString(a.getMaxHealth()) + "| Mana: " + Integer.toString(a.currentMana) + "/" + Integer.toString(a.maxMana),1000, y );
            y -= 15;
        }
        y = 800;
        for(Actor a: enemyStats)
        {
            g.drawString(a.getName() + ": Health: " + Integer.toString(a.getHealth()) + " / " + Integer.toString(a.getMaxHealth()) + "| Mana: " + Integer.toString(a.currentMana) + "/" + Integer.toString(a.maxMana),50, y);
            y -=15;
        }
        g.drawImage(image1, 50,300,null);
        g.drawImage(ulfeen, 1000,50,null);
        g.drawImage(corvi, 1000,300,null);
        g.drawImage(luke, 1000,550,null);
    }
    public void update(Graphics g)
    {

    }



}

