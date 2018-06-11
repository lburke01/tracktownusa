import java.util.ArrayList;

public abstract class Command
{


    protected String name;
    Actor caster;
    protected ArrayList<Actor> targets;
    protected Actor currentTarget;
    protected int currentIndex;
    protected int change;
    protected boolean groupTarget = true; //true = enemies, false = allies
    public Command(Actor a, ArrayList<Actor> ab)
    {
        this.caster = a;
        this.targets = ab;
        this.currentIndex = 0;
        this.currentTarget = targets.get(currentIndex);
    }
    public String getName()
    {
        return name;
    }
    public int getChange()
    {
        return change;
    }
    abstract public int calculateEffect();
    abstract void execute();
}