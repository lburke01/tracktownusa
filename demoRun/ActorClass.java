//accessors for player stats
//accessors for player stats
//created for each player
public class ActorClass
{
	public static final int MAX_BAR = 999;
	public static final int MAX_STAT = 99;
	private int actorHealth;
	private int actorMana;
	private int actorStrength;
	private int actorDefense;
	private int actorMagic;
	private int actorSpeed;
	private String[] commands;
	private String playerClass;
	public ActorClass(int choice)
	{
		if(choice == 0)
			fighter();
		else if(choice == 1)
			wizard();
		else if(choice == 2)
			healer();
		else if(choice == 3)
			ninja();
		else if(choice == 4)
			tank();
	}
	private void setHP(double multiplier)
	{
		actorHealth = Math.min( (int)((175 + (int)(Math.random() * 100)) * multiplier), MAX_BAR);
	}
	private void setMP(double multiplier)
	{
		actorMana = Math.min( (int)((75 + (int)(Math.random() * 250)) * multiplier), MAX_BAR);
	}
	private void setSTR(double multiplier)
	{
		actorStrength = Math.min( (int)((15 + (int)(Math.random() * 20)) * multiplier), MAX_STAT);
	}
	private void setMAG(double multiplier)
	{
		actorMagic = Math.min( (int)((15 + (int)(Math.random() * 20)) * multiplier), MAX_STAT);
	}
	private void setDEF(double multiplier)
	{
		actorDefense = Math.min( (int)((15 + (int)(Math.random() * 20)) * multiplier), MAX_STAT);
	}
	private void setSPD(double multiplier)
	{
		actorSpeed = Math.min( (int)((15 + (int)(Math.random() * 20)) * multiplier), MAX_STAT);
	}
	public void fighter()
	{
		playerClass = "Fighter";
		//medium health, high strength, medium defense, medium speed, low magic, low mana
		commands = new String[] {"Attack", "Skills", "Item"};
		setHP(1.75 + (Math.random() * (1.0/2.5)));
		setMP(1 + (Math.random() * (1.0/3.0)));
		setSTR(2.75 + (Math.random() * (1.0 / 2.0)));
		setMAG(1 + (Math.random() * (1.0/3.0)));
		setDEF(1.75 + (Math.random() * (1.0/2.5)));
		setSPD(1.75 + (Math.random() * (1.0/2.5)));
	}
	public void healer()
	{
		playerClass = "Healer";
		//low health, high mana, low strength, medium defense, high magic, medium speed
		commands = new String[] {"Attack", "Magic", "Item"};
		setHP(1 + (Math.random() * (1.0/3.0)));
		setMP(2.75 + (Math.random() * (1.0 / 2.0)));
		setSTR(1 + (Math.random() * (1.0/3.0)));
		setMAG(2.75 + (Math.random() * (1.0 / 2.0)));
		setDEF(1.75 + (Math.random() * (1.0/2.5)));
		setSPD(1.75 + (Math.random() * (1.0/2.5)));
	}
	public void wizard()
	{
		playerClass = "Wizard";
		//medium health, high mana, low strength, low defense, high magic, medium speed
		commands = new String[] {"Attack", "Magic", "Item"};
		setHP(1.75 + (Math.random() * (1.0/2.5)));
		setMP(2.75 + (Math.random() * (1.0 / 2.0)));
		setSTR(1 + (Math.random() * (1.0/3.0)));
		setMAG(2.75 + (Math.random() * (1.0 / 2.0)));
		setDEF(1 + (Math.random() * (1.0/3.0)));
		setSPD(1.75 + (Math.random() * (1.0/2.5)));
	}
	public void ninja()
	{
		playerClass = "Ninja";
		//low health, low mana, high strength, low defense, medium magic, high speed
		commands = new String[] {"Attack", "Skills", "Item"};
		setHP(1 + (Math.random() * (1.0/3.0)));
		setMP(1 + (Math.random() * (1.0/3.0)));
		setSTR(2.75 + (Math.random() * (1.0 / 2.0)));
		setMAG(1.75 + (Math.random() * (1.0/2.5)));
		setDEF(1 + (Math.random() * (1.0/3.0)));
		setSPD(1.75 + (Math.random() * (1.0/2.5)));
	}
	public void tank()
	{
		playerClass = "Tank";
		//high health, low mana, medium strength, high defense, low magic, low speed
		commands = new String[] {"Attack", "Defend", "Item"};
		setHP(2.75 + (Math.random() * (1.0 / 2.0)));
		setMP(0);
		setSTR(1.75 + (Math.random() * (1.0/2.5)));
		setMAG(0);
		setDEF(2.75 + (Math.random() * (1.0 / 2.0)));
		setSPD(1 + (Math.random() * (1.0/3.0)));
	}
	public String getPlayerClass()
	{
		return playerClass;
	}
	public int getHealth()
	{
		return actorHealth;
	}
	public int getMana()
	{
		return actorMana;
	}
	public int getStrength()
	{
		return actorStrength;
	}
	public int getDefense()
	{
		return actorDefense;
	}
	public int getMagic()
	{
		return actorMagic;
	}
	public int getSpeed()
	{
		return actorSpeed;
	}
	public String[] getCommandList()
	{
		return commands;
	}
}