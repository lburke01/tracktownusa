import java.util.ArrayList;

public class AttackCommand extends Command
{

    public AttackCommand(Actor a, ArrayList<Actor> ab)
    {
        super(a, ab); //ab.length should equal 1
        name = "Attack";
    }
    @Override
    public int calculateEffect()
    {
        return -1 * (int) ((Math.random() + 1) *  Math.PI - (currentTarget.getDef() * Math.random() * .33) + caster.getStr() * 1.25); //
    }
    public void execute()
    {
        if(currentTarget.isKnocked())
        {
            change = 0;
            return;
        }
        else
        {
            change = calculateEffect();
        }
        currentTarget.changeHealth(change);
    }
}
