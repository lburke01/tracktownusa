import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ButtonListener implements ActionListener
{
    Environment currentEnvironment;
    Player acting;
    JButton btnA;
    List<Ability> possAbilities;
    public Ability actingAbility;
    ArrayList<Actor> possibleTargets = new ArrayList<Actor>();
    ArrayList<Actor> targets = new ArrayList<Actor>();
    public ButtonListener(Player p, Environment e)
    {
        currentEnvironment = e;
        acting = p;
        possAbilities = p.getAbilities();
        if(p.isHealer())
            possibleTargets =  currentEnvironment.getPlayers();
        else
            possibleTargets = (ArrayList<Actor>) currentEnvironment.getEnemies();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(acting.isHealer());
        if (Display.abBar.isVisible()) {
            boolean isMatch = false;
            int i = 0;

            while (!isMatch && i < possAbilities.size()) {
                if (e.getActionCommand().equals(possAbilities.get(i).getName())) {
                    isMatch = true;
                    actingAbility = possAbilities.get(i);
                }
                i++;
            }
            if (actingAbility.getTarget()) {
                Display.allBar.setVisible(true);
            } else {
                Display.atBar.setVisible(true);
            }
            currentEnvironment.updateCurrentAbility(actingAbility);
        }
        else
        {
            if (e.getActionCommand().equals("Attack")) {
                if (Display.atBar.isVisible())
                    Display.atBar.setVisible(false);
                else
                    Display.atBar.setVisible(true);
            } else if (e.getActionCommand().equals("Use Ability")) {
                if (Display.abBar.isVisible()) {
                    Display.abBar.setVisible(false);
                } else {
                    Display.abBar.setVisible(true);
                }
            }
        }
    }
    public Ability getActingAbility(){return actingAbility;}

    }


