import java.awt.image.BufferedImage;
import java.util.*;
public class Environment
{
    Party party;
    public Ability currentAbility;
    public ArrayList<Actor> currentTargets;
    Player active;
    List<Actor> players=new ArrayList<Actor>();
    List<Actor> enemies=new ArrayList<Actor>();
    public Environment(Party p, List<Enemy> e)
    {
        for(int i=0;i<e.size();i++)
        {
            enemies.add(e.get(i));
        }
        for(int i=0;i<p.getActors().size();i++)
        {
            players.add(p.getActors().get(i));
        }
        party=p;
    }
    public List<Actor> getPlayers()
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
        for(Actor a: t)
        {
            currentTargets.add(a);
        }
        useAction();
    }
    public void useAction()
    {
        Command c;
        if(currentAbility != null && currentTargets != null)
        {
            c = new AbilityCommand(active, currentTargets, currentAbility, currentAbility.getTarget());
            c.execute();
        }
        else if(currentAbility == null && currentTargets != null)
        {
            System.out.println(currentTargets.get(0).maxHealth);
            c = new AttackCommand(active, currentTargets);
            c.execute();
            System.out.println(currentTargets.get(0).maxHealth);
        }

    }


}
