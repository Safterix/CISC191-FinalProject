package edu.sddcd.cisc191;

import edu.sdccd.cisc191.template.DataBaseApplication;
import edu.sdccd.cisc191.template.ItemTypes.Inventory;
import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.Map.Location;
import edu.sdccd.cisc191.template.ItemTypes.Consumable;
import edu.sdccd.cisc191.template.ItemTypes.Item;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.ItemTypes.SortInventory;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArchitectProjectTest
{
    JFXPanel fxPanel = new JFXPanel(); //test doesn't work without this for some reason, probably because it
    //initializes what is necessary to create JavaFX components outside an

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

        //application
        Inventory inventory = new Inventory(true); //creates inventory with randomised item
        assertFalse(inventory.containsItem("Nothing"));
        inventory.addItem(2,3, new Item()); //adds default "Nothing" item to inventory
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

        Player character = new Player("Lala");
        character.gainMoney(1000);
        character.damage(60);
        assertEquals("Lala",character.getName());
        assertEquals(40,character.getHealth());
        assertEquals(1000,character.getMoney());



    }

    /**
     * test to see of the ConsumableItems in the china consumable items array are
     * the correct ConsumableItems
     */
    @Test public void testRegionArrays() {
        assertEquals(Consumable.ConsumableItems.Apricot, Consumable.china[0]);
        assertEquals(Consumable.ConsumableItems.Peach, Consumable.china[1]);
        assertEquals(Consumable.ConsumableItems.Tea, Consumable.china[2]);
        assertEquals(Consumable.ConsumableItems.Rice, Consumable.china[3]);
        assertEquals(Consumable.ConsumableItems.Plum, Consumable.china[4]);
    }

    /**
     * tests to see if the NPC health label shows up correctly
     */
    @Test public void testNPCHealthLabel(){
       NPC npc = new NPC(); //make a new NPC
       npc.damage(10); // damage them by 10 hp, so 100-90 = 10 HP
       GameLabel health = npc.showHealth(); //show their health label
       assertEquals("Health: 90/100",health.getText()); //check of the label words are correct


    }

    /**
     * tests to see of the compareTo methods work
     */
    @Test public void testCompareTo(){
        Consumable rice = new Consumable(Consumable.ConsumableItems.Rice);
        Consumable apricot = new Consumable(Consumable.ConsumableItems.Apricot);
        assertEquals(-1,rice.compareTo(apricot));
        assertEquals(1,apricot.compareTo(rice));
        }
    /**
     * tests to see of item sorting works
     *
     */
        @Test public void testSort(){
        ArrayList<Item> testList = new ArrayList<Item>();
            testList.add(new Consumable(Consumable.ConsumableItems.Rice));
            testList.add(new Consumable(Consumable.ConsumableItems.Apricot));
            testList.add(new Consumable(Consumable.ConsumableItems.Rice));
            testList.add(new Consumable(Consumable.ConsumableItems.Apricot));
            testList.add(new Item());
            testList.add(new Item());
            Collections.sort(testList);
            //rice -> apricots -> nothing
            assertEquals("Rice", testList.get(0).getName());
            assertEquals("Rice", testList.get(1).getName());
            assertEquals("Apricot", testList.get(2).getName());
            assertEquals("Apricot", testList.get(3).getName());
            assertEquals("Nothing",testList.get(4).getName());
            assertEquals("Nothing",testList.get(5).getName());
        }

    /**
     * tests if row is empty works
     */
    @Test public void testRowisEmpty(){
        Inventory inv = new Inventory();
        assertTrue(inv.isEmpty());

        inv.addItem(new Item(true));
        assertFalse(inv.isEmpty());

    }

    /**
     * tests to see if adding items works
     * what happens when inv is full?
     */
    @Test public void testAddItemInventory(){
        Inventory inv = new Inventory(true);
        inv.addItem(4,3,new Consumable(Consumable.ConsumableItems.Rice));
        assertEquals("Rice",inv.getItem(4,3).getName());

        Inventory inv2 = new Inventory(true); //make full inv
        inv2.addItem(new Item(true)); //try to add item
        assertEquals(24,inv.getAllItems().size()); //shouldnt have added

    }
    /**
     * tests to see if sorting inventory work
     * TODO idk why it doesnt work
     */
    @Test public void testSortInv(){
        Inventory inv = new Inventory();
        inv.addItem(4,3,new Consumable(Consumable.ConsumableItems.Rice));
        inv.addItem(4,2,new Consumable(Consumable.ConsumableItems.Apricot));
         inv.sortInv();
       assertTrue(inv.containsItem("Rice"));
       assertEquals("Rice",inv.getItem(0,0).getName());
        assertEquals("Apricot",inv.getItem(0,1).getName());
        assertEquals("Nothing",inv.getItem(0,2).getName());

    }
    /**
     * tests to see if sorting inventory work
     * TODO idk why it doesnt work
     */
    @Test public void testSortInvRandom(){
        Inventory inv = new Inventory(true);
        inv.sortInv();
        System.out.print(inv);

    }

    /**
     * tests to see if Locations works as intended, checks if the previous, current, and next are correct
     * starts from china
     */
    @Test public void testLocationChinaStart(){
        //makes a location that starts in china
        Location chinaStart = new Location(true);

        //should start at Xian
        assertEquals(Location.SpecificLocation.Xian,chinaStart.getLocation());
        //checks to see if the next location is at Zhangye
        assertEquals(Location.SpecificLocation.Zhangye,chinaStart.getNext());
        //move up one
        chinaStart.move();
        assertEquals(Location.SpecificLocation.Zhangye,chinaStart.getLocation());
        //next should NOT be zhangye anymore
        assertNotEquals(Location.SpecificLocation.Zhangye,chinaStart.getNext());
        //shouldve been at Xian before
        assertEquals(Location.SpecificLocation.Xian,chinaStart.getPrevious());
    }
    /**
     * tests to see if Locations works as intended, checks if the previous, current, and next are correct
     * starts from europe
     */
    @Test public void testLocationEuropeStart(){
        //makes a location that starts in china
        Location europeStart = new Location(false);

        //should NOT start at Xian but start at constantinople
        assertNotEquals(Location.SpecificLocation.Xian,europeStart.getLocation());
        assertEquals(Location.SpecificLocation.Constaninople,europeStart.getLocation());
        //checks to see if the next location is at Zhangye
        assertEquals(Location.SpecificLocation.Zhangye,europeStart.getNext());

        //move up one
        europeStart.move();

        //next should NOT be zhangye anymore
        assertNotEquals(Location.SpecificLocation.Zhangye,europeStart.getNext());
        //shouldve been at Constantinople before
        assertEquals(Location.SpecificLocation.Constaninople,europeStart.getPrevious());
    }

    @Test public void testConvertingnode(){
        Inventory inventory = new Inventory();
        inventory.addItem(0,0, new Consumable(Consumable.ConsumableItems.Rice));
        inventory.addItem(1,0, new Consumable(Consumable.ConsumableItems.Rice));
        inventory.addItem(2,0, new Consumable(Consumable.ConsumableItems.Rice));
        inventory.addItem(3,0, new Consumable(Consumable.ConsumableItems.Rice));
        SortInventory sorting = new SortInventory(inventory);
        sorting.convertToNode(null);

    }

    /**tests to see if counting duplicates work
     *
     */
    @Test public void testCountingDoopsEmpty(){
        //make empty inventory
        Inventory inventory = new Inventory();
        SortInventory sorting = new SortInventory(inventory);
        sorting.convertToNode(null);
        sorting.addNodes();
        sorting.inOrderTraverse(sorting.getRoot());
        //there should be 24 nothings
        assertEquals("Nothing 24", sorting.getRoot().toString());
    }
    /**tests to see if counting duplicates work
     * with 20 nothing, and 4 rice
     */
    @Test public void testCountingDoops(){
        //make empty inventory
        Inventory inventory = new Inventory();
        inventory.addItem(0,0, new Consumable(Consumable.ConsumableItems.Rice));
        inventory.addItem(1,0, new Consumable(Consumable.ConsumableItems.Rice));
        inventory.addItem(2,0, new Consumable(Consumable.ConsumableItems.Rice));
        inventory.addItem(3,0, new Consumable(Consumable.ConsumableItems.Rice));
        SortInventory sorting = new SortInventory(inventory);
        sorting.convertToNode(null);
        sorting.addNodes();
        sorting.inOrderTraverse(sorting.getRoot());
        //check system out if Nothing 20 Rice 4

    }
    /**tests to see if counting duplicates work
     * with random items
     * TODO DOESNT WORK IDEALLY bcoz items not  sorted in corerct order...why...
     */
    @Test public void testCountingDoopsRandom(){
        //make empty inventory
        Inventory inventory = new Inventory(true);
        SortInventory sorting = new SortInventory(inventory);
        sorting.convertToNode(null);
        sorting.addNodes();
        sorting.inOrderTraverse(sorting.getRoot());
        //has 24 items
        // proper order is
        //rice, tea, apricot, plum , peach, wine

    }

    /**
     * tests to see if the  NPC database has NPCs in it
     */
    @Test public void testNPCDatabase(){
        DataBaseApplication db = new DataBaseApplication();
        db.init();

             assertEquals("Marky 10 100 0",  db.getNPCs().get(0).toString());
            assertEquals("Meowky 3 100 0",  db.getNPCs().get(1).toString());
            assertEquals("Tao Yu 100 100 50",  db.getNPCs().get(2).toString());
            assertEquals("Creature 10000 100 0",  db.getNPCs().get(3).toString());
            assertEquals("Cat 3 100 0",  db.getNPCs().get(4).toString());
    }

    /**
     * tests to see if players are sorteed by score
     * corectly  using compareTo()
     * higheset to greeatest
     */
    @Test public void testScoresOrderr(){

        Player winner = new Player("Winner");
                winner.addScore(10000000);
        Player loser = new Player("Loser");
        loser.addScore(3);
        Player guy = new Player("Guy");
        guy.addScore(100);
        Player hi = new Player("hi");
        hi.addScore(5000);
        ArrayList<Player> leadeBoard  = new ArrayList<>();
        leadeBoard.add(winner);
        leadeBoard.add(loser);
        leadeBoard.add(guy);
        leadeBoard.add(hi);
        leadeBoard.sort(Player::compareTo);
        assertEquals(winner,leadeBoard.get(0));

        assertEquals(hi,leadeBoard.get(1));

        assertEquals(guy,leadeBoard.get(2));

        assertEquals(loser,leadeBoard.get(3));


    }
}