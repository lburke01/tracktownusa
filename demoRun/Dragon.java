public class Dragon extends Enemy
{
    String name = "Dragon";
    int maxHealth;
    int currentHealth;
    int maxStrength;
    int maxDefense;
    int maxSpeed;
    int strength;
    int defense;
    int speed;
    int count;
    boolean isPlayer;
    int target;
    int gold;
    boolean isKnocked;
    public Dragon(int level)
    {
        maxHealth = 15 + (level*6);
        currentHealth = maxHealth;
        maxStrength = 20 + (level * 6);
        maxDefense = 8 + (level * 3);
        maxSpeed = 5 +  (level * 3);
        isPlayer = false;
        strength = maxStrength;
        defense = maxDefense;
        speed = maxSpeed;
        count = 0;
        gold = level * 100;
    }
    public Environment act(Environment e)
    {
        if(count==2)
        {
            for(int i=0;i<e.getPlayers().size();i++)
            {
                e.getPlayers().get(i).changeHealth(-1*((int)(((double)e.getPlayers().get(i).getMaxHealth())*.3)));
            }
        }
        else
            target=findTarget(e);
        e.getPlayers().get(target).changeHealth(-1*baseAttack(e.getPlayers().get(target).getDef()));
        return e;
    }
    public int baseAttack(int d)
    {
        return (int)(((double)strength)*(100.0/(100 + d)));
    }
    public int getHealth()
    {
        return currentHealth;
    }
    public int getDef()
    {
        return defense;
    }
    public int getMaxHealth(){return maxHealth;}
    public void changeHealth(int change)
    {

    }
    public String getName(){return name;}
    public int getSpd(){return speed;}
    public boolean isKnocked(){return isKnocked;}
    public int getStr(){return strength;}
}
