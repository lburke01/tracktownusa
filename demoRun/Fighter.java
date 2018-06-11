import java.awt.image.BufferedImage;

public class Fighter extends Player
{
	private int enemiesLeft = 0;
	private int level;
	private boolean beenLevel_1;
	private boolean beenLevel_2;
	private boolean beenLevel_3;
	public Fighter(String n, ActorClass c , BufferedImage s)
	{
		this(n, c, 1, s);

	}
	public Fighter(String n, ActorClass c, int level, BufferedImage s)
	{
		super(n, c, level, s);
		this.level = level;
		sprite = s;
		setLevel(level);
	}

	public void levelUP()
	{
		if(!moreEnemiesRequired() && level < MAX_LEVEL)
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
			enemiesLeft = 5;
		}
		else if(level == 2)
		{
			beenLevel_2 = true;
			enemiesLeft = 10;
			abilities.add(GameObjects.getAllFighterSkills()[0]);
			abilities.add(GameObjects.getAllFighterSkills()[1]);
			incrementAllStats(2, 1, 3, 1, 2, 2);
			if(!beenLevel_1)
				setLevel(level - 1);
		}
		else if(level == 3)
		{
			beenLevel_3 = true;
			enemiesLeft = 35;
			abilities.add(GameObjects.getAllFighterSkills()[2]);
			if(!beenLevel_2)
				setLevel(level - 1);
		}
		else if(level == MAX_LEVEL)
		{
			enemiesLeft = 0;
			abilities.add(GameObjects.getAllFighterSkills()[3]);
			if(!beenLevel_3)
				setLevel(level - 1);
		}
	}
	private boolean moreEnemiesRequired()
	{
		return enemiesLeft > 0;
	}

}
