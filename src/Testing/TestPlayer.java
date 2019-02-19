package Testing;

import models.Player;


/**
 *
 * @author The Razorback
 */
public class TestPlayer {

    public static void main(String[] args)
    {
        Player player = new Player();
        player.setPlayerName("Trial");
        
        if (player.getPlayerName()!="Trial")
        {
            System.out.println("Bad Result");
        }
        else
        {
            System.out.println("Good Result");
        }
    }
    
}
