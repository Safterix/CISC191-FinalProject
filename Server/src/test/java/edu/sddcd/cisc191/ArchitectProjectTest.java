package edu.sddcd.cisc191;

import edu.sdccd.cisc191.template.Characters.Inventory;
import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.ItemTypes.Item;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.Networking.Client;
import edu.sdccd.cisc191.template.Networking.Server;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArchitectProjectTest
{



    /**
     * This method is called before every test case method.
     */
    @BeforeAll
    public void setUp() {

    }


    /**
     * Tests the method containsItem by creating a random inventory, adding a default "Nothing" item, and checking if
     * it is in the inventory
     */
    @Test public void testInventoryContainsItem()
    {
        JFXPanel fxPanel = new JFXPanel();  //test doesn't work without this for some reason, probably because it
                                            //initializes what is necessary to create JavaFX components outside an
                                            //application
        Inventory inventory = new Inventory(true); //creates inventory
        assertFalse(inventory.containsItem("Nothing"));
        inventory.addItem(2, 3, new Item()); //adds default "Nothing" item to inventory
        assertTrue(inventory.containsItem("Nothing"));
    }

    //see below for example test
//    /**
//     * Test row sum calculated correctly including for nonsquare arrays
//     */
//    @Test public void testRowSum() {
//        assertEquals(6, ArrayLab.rowSum(basic, 0));
//        assertEquals(15, ArrayLab.rowSum(basic, 1));
//        assertEquals(24, ArrayLab.rowSum(basic, 2));
//        assertEquals(30, ArrayLab.rowSum(nonsquare, 2));
//    }

    /**
     * Tests to see if saving the score works
     * compares correct string to output
     */
    @Test public void testSaveScoreWorks(){

        JFXPanel fxPanel = new JFXPanel(); //test doesn't work without this for some reason
        //make a view game to use the nonstatic writeFile()
        ViewGame game = new ViewGame();
        //makes a player named "Lala" who wants to explore the world and also has a score of 1000
        Player player = new Player("Lala");
        player.setGoal("Explore the world");
        player.addScore(1000);
        //makes a test file to write output too called ScoreTest.txt
        File scoreTestFile = new File("ScoreTest.txt");
        //the correct output
        String correct =   "Thank you for playing the silk road game!\nIn your recent run as Lala"+
                ", you wanted to explore the world. You got 1000 points! Good Job!\n\n"+
                "Your Achievements:";
        //use writeFile() to output the score and info of the player
        game.writeFile(player,scoreTestFile);
        //try to make scanner and read ALL data on the ScoreTest.txt file to see if t matches
        try {
            Scanner readFile = new Scanner(scoreTestFile);
            readFile.useDelimiter("\\Z");

                assertEquals(correct, readFile.next());
                scoreTestFile.deleteOnExit();
            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }



    }

    /**
     * tests to see if Player really does extend Character
     * uses methods in Character on a player object
     */
    @Test public void testPlayerCharacterMethods(){

        JFXPanel fxPanel = new JFXPanel(); //test doesn't work without this for some reason
        Player character = new Player("Lala");
        character.gainMoney(1000);
        character.damage(60);
        assertEquals("Lala",character.getName());
        assertEquals(40,character.getHealth());
        assertEquals(1000,character.getMoney());



    }

}