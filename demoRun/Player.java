import java.awt.image.BufferedImage;
import java.util.*;
public abstract class Player extends Actor
{
	private boolean isKnocked = false;
	protected String name;
	protected String playerClass;
	protected String[] commands;
	protected final static int MAX_LEVEL = 4;
	protected List<Ability> abilities = new ArrayList<Ability>();
	protected boolean isHealer;


	public Player(String n, ActorClass c, int level, BufferedImage s)
	{
		name = n;
		playerClass = c.getPlayerClass();
		maxHealth = c.getHealth();
		maxMana = c.getMana();
		currentHealth = maxHealth;
		currentMana = maxMana;
		maxStrength = c.getStrength();
		maxDefense = c.getDefense();
		maxMagic = c.getMagic();
		maxSpeed = c.getSpeed();
		strength = maxStrength;
		defense = maxDefense;
		magic = maxMagic;
		speed = maxSpeed;
		commands = c.getCommandList();
		isPlayer = true;
		sprite = s;
	}
	protected void incrementAllStats(int HPmult, int MPmult, int strMult, int magMult, int defMult, int spdMult)
	{
		maxHealth += 15 * HPmult;
		maxMana += 15 * MPmult;
		maxStrength += 2 * strMult;
		maxDefense += 2 * defMult;
		maxMagic += 2 * magMult;
		maxSpeed += 2 * spdMult;
		if(maxHealth > ActorClass.MAX_BAR) maxHealth = ActorClass.MAX_BAR;
		if(maxMana > ActorClass.MAX_BAR) maxMana = ActorClass.MAX_BAR;
		if(maxStrength > ActorClass.MAX_STAT) maxStrength = ActorClass.MAX_STAT;
		if(maxMagic > ActorClass.MAX_STAT) maxMagic = ActorClass.MAX_STAT;
		if(maxDefense > ActorClass.MAX_STAT) maxDefense = ActorClass.MAX_STAT;
		if(maxSpeed > ActorClass.MAX_STAT) maxSpeed = ActorClass.MAX_STAT;
		currentHealth = maxHealth;
		currentMana = maxMana;
		strength = maxStrength;
		defense = maxDefense;
		magic = maxMagic;
		speed = maxSpeed;
	}
	public void changeHealth(int change)
	{
		if(currentHealth + change > maxHealth) //Prevents over-healing by setting currentHealth to maxHealth if the sum is greater than maxHealth
			currentHealth = maxHealth;
		else
			currentHealth += change; //if change is damage, it is a negative value; if change is healing, it is a positive value

	}

	public void changeMana(int change)
	{
		if(currentMana + change > maxMana) //uses same control loop system as in changeHealth
			currentMana = maxMana;
		else
			currentMana += change; //if magic is used, change is negative; if mana potion is used, change is positive
	}
	public void knockOut()
	{
		isKnocked = true;
		currentHealth = 0;
		//come back to this
	}
	public boolean isKnocked()
	{
		return isKnocked;
	}
	protected abstract void setLevel(int level);

	@Override
	public int getHealth() {
		return currentHealth;
	}


	public int getMana() {
		return currentMana;
	}

	@Override
	public int getStr() {
		return strength;
	}

	public int getMag() {
		return magic;
	}

	@Override
	public int getDef() {
		return defense;
	}

	@Override
	public int getSpd() {
		return speed;
	}
	@Override
	public int getMaxHealth()
	{
		return maxHealth;
	}

	public int getMaxMana()
	{
		return maxMana;
	}
	public ArrayList<Ability> getAbilities()
	{
		return (ArrayList<Ability>) abilities;
	}
	public boolean isHealer(){return isHealer;}
	public String getName(){return name;}
}