import java.util.*;
public class DungFloor
{
    int goldLoot;
    int floor;
    List<Enemy> enemies = new ArrayList<Enemy>();
    public DungFloor(int f, List<Enemy> e)
    {
        goldLoot = 0;
        for(int i = 0;i < e.size(); i++)
        {
            enemies.add(e.get(i));
            goldLoot+=e.get(i).getGold();
        }
        floor=f;
    }
    public List<Enemy> getEnemies()
    {
        return enemies;
    }
}