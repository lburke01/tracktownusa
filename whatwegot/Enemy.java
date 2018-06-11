import java.awt.image.BufferedImage;

public abstract class Enemy extends Actor implements java.lang.Cloneable
{
	String name;
	int target;
	int gold;
	boolean isKnocked = false;
	BufferedImage sprite;


	public void act(Environment e) throws CloneNotSupportedException
	{
		target=findTarget(e);
		e.getPlayers().get(target).changeHealth(-1*baseAttack(baseAttack(e.getPlayers().get(target).getDef())));
	}
	public int getMaxHealth()
	{
		return maxHealth;
	}
	public int baseAttack(int d)
	{
		return (int)(((double)strength)*(100.0/(100 + d)));
	}
	public int getGold()
	{
		return gold;
	}
	public void changeHealth(int change)
	{
		if(currentHealth + change > maxHealth) //Prevents over-healing by setting currentHealth to maxHealth if the sum is greater than maxHealth
			currentHealth = maxHealth;
		else if(currentHealth + change < 0)
			currentHealth = 0;
		else
			currentHealth += change; //if change is damage, it is a negative value; if change is healing, it is a positive value
	}
	public BufferedImage getSprite(){return sprite;}
	public void knockOut(){isKnocked = true;}
	public int findTarget(Environment e)
	{
		target=((int)(Math.random()*((double)e.getPlayers().size())));
		for(int i=0;i<e.getPlayers().size();i++)
		{
			if(e.getPlayers().get(i).getHealth()<((int)e.getPlayers().get(i).getMaxHealth()*.3))
			{
				if(e.getPlayers().get(i).getHealth()<e.getPlayers().get(target).getHealth())
				{
					target=i;
				}
			}

		}
		return target;
	}
	public Object clone()throws CloneNotSupportedException
	{
		return super.clone();
	}
	public String getName(){return name;}
}