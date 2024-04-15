package edu.sddcd.cisc191;

import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.Networking.Client;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * must run server before doing these tests
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArchitectProjectNetworkingTest
{



    /**
     * This method is called before every test case method.
     */
    @BeforeAll
    public void setUp() {

    }

    /**
     * tests to see if the client request works, makes a player and sees if it does indeed print out their score
     */
    @Test public void testPublishScore(){
        JFXPanel fxPanel = new JFXPanel(); //test doesn't work without this for some reason
        //make client and view game obj
        Client client = new Client();
        ViewGame game = new ViewGame();

        //make player named Lala with 1000 points
        Player player = new Player("Lala");
        player.addScore(1000);

        //try to start connection
        try {
            client.startConnection("127.0.0.1", 6000);
            //send the player name and score
            game.makeHighScore(client.sendRequest(player.getName(), player.getScore()).toString());
            client.stopConnection();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals("Lala: 1000",game.getScoresHolder());
    }


}