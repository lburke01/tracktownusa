import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AuxiliaryButtonListener implements ActionListener
{
    Player acting;
    List<Ability> possAbilities;
    Ability actingAbility;
    Environment curEv;
    ArrayList<Actor> possibleTargets = new ArrayList<Actor>();
    ArrayList<Actor> targets = new ArrayList<Actor>();
    public AuxiliaryButtonListener(Player p, Environment e)
    {
        curEv = e;
        acting = p;
        possAbilities = p.getAbilities();
        if(p.isHealer())
            possibleTargets = (ArrayList<Actor>) e.getPlayers();
        else
            possibleTargets = (ArrayList<Actor>) e.getEnemies();
    }
    public void actionPerformed(ActionEvent e)
    {
        int i;

        if (e.getActionCommand().equals("All"))
        {
            for(int x = 0; x < possibleTargets.size(); x++)
                targets.add(possibleTargets.get(x));
        } else {
            boolean targetMatch = false;
            i = 0;
            while (!targetMatch && i < possibleTargets.size())
            {
                if (e.getActionCommand().equals(possibleTargets.get(i).getName()))
                {
                    targetMatch = true;
                    targets.add(possibleTargets.get(i));
                }
                i++;
            }
        }

        System.out.println(targets.get(0).getName());
        curEv.updateCurrentTarget(targets);
    }

}
