import java.awt.image.BufferedImage;
import java.util.*;
public class Environment
{
    public static boolean hasRan;
    List<Player> party;
    public Ability currentAbility;
    public ArrayList<Actor> currentTargets;
    Fighter active;
    boolean endGame;
    boolean result;
    ArrayList<Actor> players=new ArrayList<Actor>();
    List<Actor> enemies=new ArrayList<Actor>();
    public Environment(Fighter act, List<Player> p, List<Enemy> e)
    {
        party = p;
        active = act;
        for(int i=0;i<e.size();i++)
        {
            enemies.add(e.get(i));
        }

    }
    public void addActor(Player p){players.add(p);}
    public ArrayList<Actor> getPlayers()
    {
        return players;
    }
    public List<Actor> getEnemies()
    {
        return enemies;
    }
    public void updateCurrentAbility(Ability a){currentAbility = a;}
    public void updateCurrentTarget(ArrayList<Actor> t)
    {
        currentTargets = t;
        useAction();
    }
    public void useAction()
    {
        Command c;
        if(currentAbility != null && currentTargets != null)
        {
            System.out.println(currentTargets.get(0).getName());
            System.out.println(currentTargets.get(0).getHealth());
            c = new AbilityCommand(active, currentTargets, currentAbility, currentAbility.getTarget());
            c.execute();
            active.reverseTurn();
        }
        else if(currentAbility == null && currentTargets != null)
        {
            System.out.println(currentTargets.get(0).getHealth());
            c = new AttackCommand(active, currentTargets);
            c.execute();
            active.reverseTurn();
            System.out.println(currentTargets.get(0).getHealth());

        }
        active.reverseTurn();
        hasRan = true;
    }
    public boolean partyKnocked()
    {
        for(Actor a: players)
        {
            if(!a.isKnocked())
                return false;
        }
        return true;
    }
    public boolean enemyKnocked()
    {
        for(Actor a: enemies)
        {
            if(!a.isKnocked())
                return false;
        }
        return true;
    }


}
