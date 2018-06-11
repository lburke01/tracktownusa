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
    boolean isTurn;
    public Dragon(int level)
    {
        maxHealth = 350 + (level*20);
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
    public void act(Environment e)
    {
        e.getPlayers().get(0).changeHealth(-1*baseAttack(e.getPlayers().get(0).getDef()));
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
        if(currentHealth + change > maxHealth) //Prevents over-healing by setting currentHealth to maxHealth if the sum is greater than maxHealth
            currentHealth = maxHealth;
        else if(currentHealth + change < 0)
            currentHealth = 0;
        else
            currentHealth += change; //if change is damage, it is a negative value; if change is healing, it is a positive value
    }
    public String getName(){return name;}
    public int getSpd(){return speed;}
    public boolean isKnocked(){return isKnocked;}
    public int getStr(){return strength;}
    public boolean isTurn(){return isTurn;}
}
