import java.awt.image.BufferedImage;

public class Tank extends Player
{
    private int takenDamageNeeded;
    private int level;
    private boolean beenLevel_1;
    private boolean beenLevel_2;
    private boolean beenLevel_3;
    public Tank(String n, ActorClass c, BufferedImage s)
    {
        this(n, c, 1, s);
    }
    public Tank(String n, ActorClass c, int level, BufferedImage s)
    {
        super(n, c, level, s);
        this.level = level;
        setLevel(level);
    }
    public void levelUP()
    {
        if(!moreDamageNeeded() && level < MAX_LEVEL)
        {
            setLevel(level);
        }
    }

    protected void setLevel(int level)
    {
        if(level == 1)
        {
            beenLevel_1 = true;
            takenDamageNeeded = 500;
        }
        else if(level == 2)
        {
            beenLevel_2 = true;
            takenDamageNeeded = 2100;
            incrementAllStats(3, 0, 2, 0, 3, 1);
            if(!beenLevel_1)
                setLevel(level - 1);
        }
        else if(level == 3)
        {
            beenLevel_3 = true;
            takenDamageNeeded = 5500;
            incrementAllStats(3, 0, 2, 0, 3, 1);
            if(!beenLevel_2)
                setLevel(level - 1);
        }
        else if(level == MAX_LEVEL)
        {
            takenDamageNeeded = 0;
            incrementAllStats(3, 0, 2, 0, 3, 1);
            if(!beenLevel_3)
                setLevel(level - 1);
        }
    }
    private boolean moreDamageNeeded()
    {
        return takenDamageNeeded > 0;
    }
}