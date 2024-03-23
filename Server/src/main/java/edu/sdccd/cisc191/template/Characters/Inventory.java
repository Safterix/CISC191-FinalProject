package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

/**
 * makes inventory which is a 6x4 array list of items
 * displayed as a grid of items
 */
public class Inventory{
    private ArrayList<ArrayList<Item>> storage= new ArrayList<ArrayList<Item>>();
    // inventory is a 2d arraylist with items
    private final int rowSize = 6; int colSize = 4; //arraylist is 6x4
    public Inventory(){

        for(int row=0; row<rowSize;row++){
            //make the rows
            storage.add(new ArrayList<Item>());
            for(int col=0;col<colSize;col++){
                //adds default Nothing item in each cell
                storage.get(row).add(new Item());

            }
        }
    }

    /**
     * adds random Nothing item to each cell
     */
    public Inventory(boolean random){

        for(int row=0; row<rowSize;row++){
            //make the rows
            storage.add(new ArrayList<Item>());
            for(int col=0;col<colSize;col++){
                //adds random item in each cell
                storage.get(row).add(new Item(true));

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
        storage.get(row).add(item);
    }
    /**
     * removes one item
     * @param row which row is in
     * @param col which col
     */
    public void removeItem(int row, int col){
        //makes empty item in place of it
        storage.get(row).remove(col);
    }

    /**
     * displays the inventory on a gridpane of buttons
     * @return gridpane of buttons, visual of inventory
     */
    public GridPane displayInventory(){
        GridPane inventoryCells = new GridPane();
        sortInv();
        for(int row=0; row<rowSize;row++){
            for(int col=0;col<colSize;col++){
                //adds everycell
                inventoryCells.add(storage.get(row).get(col).displayItem(),row,col,1,1);

            }
        }
    return inventoryCells;

    }

    /**
     * TODO attempt at sorting inv items
     */
    public void sortInv(){
        for(int row=0; row<rowSize;row++){
                Collections.sort(storage.get(row));

    }}
    /**
     * Checks if the inventory contains a certain item (could be used for NPC dialogue options)
     * @param itemName the item to check for
     * @return true if the inventory contains the item, false otherwise
     */
    public boolean containsItem(String itemName)
    {
        for (ArrayList<Item> row : storage)
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
