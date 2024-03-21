package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.layout.GridPane;

/**
 * makes inventory which is a 6x4 array of items
 * displayed as a grid of items
 */
public class Inventory{
    private Item[][] storage = new Item[6][4]; // inventory is 6x4 item array
    public Inventory(){
        for(int row=0; row<storage.length;row++){
            for(int col=0;col<storage[row].length;col++){
                //adds default Nothing item in each cell
                storage[row][col]= new Item();

            }
        }
    }

    /**
     * adds random Nothing item to each cell
     */
    public Inventory(boolean random){
        for(int row=0; row<storage.length;row++){
            for(int col=0;col<storage[row].length;col++){
                //adds random item in each cell
                storage[row][col]= new Item(true);

            }
        }
    }

    /**
     * adds one item
     * @param row which row will item be in
     * @param col which col
     * @param item what is the item
     */
    public void addItem(int row, int col, Item item){
        storage[row][col]= item;
    }
    /**
     * removes one item
     * @param row which row is in
     * @param col which col
     */
    public void removeItem(int row, int col){
        //makes empty item in place of it
        storage[row][col]= new Item();
    }

    /**
     * displays the inventory on a gridpane of buttons
     * @return gridpane of buttons, visual of inventory
     */
    public GridPane displayInventory(){
        GridPane inventoryCells = new GridPane();
        for(int row=0; row<storage.length;row++){
            for(int col=0;col<storage[row].length;col++){
                //adds everycell
                inventoryCells.add(storage[row][col].displayItem(),row,col,1,1);

            }
        }
    return inventoryCells;

    }

    /**
     * Checks if the inventory contains a certain item (could be used for NPC dialogue options)
     * @param itemName the item to check for
     * @return true if the inventory contains the item, false otherwise
     */
    public boolean containsItem(String itemName)
    {
        for (Item[] row : storage)
        {
            for (Item item : row)
            {
                if (item.getName().equals(itemName))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
