import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Demo
{
    Dragon dragon = new Dragon(2);
    Dragon mistaK = new Dragon(1);
    Fighter ulfeen= new Fighter("Ulfeen", new ActorClass(0),2, new BufferedImage(1,2,3));
    Fighter corvi = new Fighter("Corvi", new ActorClass(0),2, new BufferedImage(1,2,3));
    Healer luke = new Healer("Luke", new ActorClass(2),2, new BufferedImage(1,2,3));
    ArrayList<Player> allPlayers = new ArrayList<Player>();
    ArrayList<Enemy> allEnemies = new ArrayList<Enemy>();
    Player activePlayer;
    Environment demoEnv;
    Party demoParty;
    Display demo;
    public Demo()
    {
        allPlayers.add(ulfeen);
        allPlayers.add(corvi);
        allPlayers.add(luke);
        allEnemies.add(dragon);
        allEnemies.add(mistaK);
        demoParty = new Party(allPlayers);
        demoEnv = new Environment(demoParty, allEnemies);
        demo = new Display(corvi, demoEnv, demoParty);
        activePlayer = corvi;
        demo.run(activePlayer, demoEnv);
    }
    public static void main(String[] args)
    {
        Demo a = new Demo();
    }
    public void run(){demo.run(activePlayer, demoEnv);}
}

