import java.util.*;
public class Party
{
  static List<Player> players = new ArrayList<Player>();
  final int maxGold = 9999;
  static int gold = 50;

  //static List<Item> bag = new ArrayList<Item>();
  public Party(List<Player> allPlayers)
  {
    for(int i = 0; i < allPlayers.size(); i ++)
      players.add(allPlayers.get(i));
  }

  public List<Player> getActors()
  {
    return players;
  }

}