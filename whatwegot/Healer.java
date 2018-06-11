import java.awt.image.BufferedImage;

public class Healer extends Player
{
	private int healingLeft = 0;
	private int level;
	private boolean beenLevel_1;
	private boolean beenLevel_2;
	private boolean beenLevel_3;
	public Healer(String n, ActorClass c, BufferedImage s)
	{
		this(n, c, 1, s);
	}
	public Healer(String n, ActorClass c, int level, BufferedImage s)
	{
		super(n, c, level, s);
		this.level = level;
		setLevel(this.level);
		isHealer = true;
	}

	public void levelUP()
	{
		if(!moreHealingRequired() && level < MAX_LEVEL)
		{
			level ++;
			setLevel(level);
		}
	}
	@Override
	protected void setLevel(int level)
	{
		if(level == 1)
		{
			beenLevel_1 = true;
			healingLeft = 600;
			abilities.add(GameObjects.getAllHealerMagic()[0]);
		}
		else if(level == 2)
		{
			beenLevel_2 = true;
			healingLeft = 2400;
			abilities.add(GameObjects.getAllHealerMagic()[1]);
			abilities.add(GameObjects.getAllHealerMagic()[2]);
			abilities.add(GameObjects.getAllHealerMagic()[3]);
			incrementAllStats(1, 3, 1, 3, 2, 2);
			if(!beenLevel_1)
				setLevel(level - 1);
		}
		else if(level == 3)
		{
			beenLevel_3 = true;
			healingLeft = 7200;
			abilities.add(GameObjects.getAllHealerMagic()[4]);
			incrementAllStats(1, 3, 1, 3, 2, 2);
			if(!beenLevel_2)
				setLevel(level - 1);
		}
		else if(level == MAX_LEVEL)
		{
			healingLeft = 0;
			abilities.add(GameObjects.getAllHealerMagic()[5]);
			abilities.add(GameObjects.getAllHealerMagic()[6]);
			incrementAllStats(1, 3, 1, 3, 2, 2);
			if(!beenLevel_3)
				setLevel(level - 1);
		}
	}
	private boolean moreHealingRequired()
	{
		return healingLeft > 0;
	}
}