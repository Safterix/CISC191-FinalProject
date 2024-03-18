package edu.sddcd.cisc191;

import edu.sdccd.cisc191.template.Characters.Inventory;
import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArchitectProjectTest
{



    /**
     * This method is called before every test case method.
     */
    @BeforeAll
    public void setUp() {

    }



    @Test public void testInventoryContainsItem()
    {
        JFXPanel fxPanel = new JFXPanel(); //test doesn't work without this for some reason
        Inventory inventory = new Inventory(); //creates inventory
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


}