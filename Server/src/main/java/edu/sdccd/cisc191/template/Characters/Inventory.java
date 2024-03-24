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
     * @param item what is the item
     */
    public void addItem(int row, Item item){
            for(int i=0; i<rowSize;i++){
                if(rowIsEmpty(i))
                    storage.get(row).add(item);
                }
    }
    /**
     * adds one item, replaces actaully
     * @param row which row will item be in
     * @param col what col is the item being removed from
     * @param item what is the item
     */
    public void addItem(int row, int col, Item item){

                storage.get(row).remove(col);
                storage.get(row).add(item);
        }
    /**
     * gets item from specic row and col
     * @param row which row will item be in
     * @param col what col
     * @return the item
     */
    public Item getItem(int row, int col){

        return storage.get(row).get(col);
    }
    /**
     * gets row
     * @param row the row that you want to get
     * @return the row arraylist
     */
    public ArrayList<Item> getRow(int row){

        return storage.get(row);
    }
    /**
     * removes one item
     * @param row which row is in
     * @param col which col
     */
    public void removeItem(int row, int col){
        //makes empty item in place of it
        storage.get(row).remove(col);
        storage.get(row).add(new Item());
        sortInv();
    }

    /**
     * displays the inventory on a gridpane of buttons
     * @return gridpane of buttons, visual of inventory
     */
    public GridPane displayInventory(){
        sortInv();
        GridPane inventoryCells = new GridPane();
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
            //sorts items
                storage.get(row).sort(Item::compareTo);

    }}
    public boolean rowIsEmpty(int row){

        if(row<rowSize){
            for(Item item: storage.get(row)){
            if(!item.getName().equals("Nothing")){
                return false;
            }
        }
    }
        return true;
    }

    /**
     * Checks if the inventory contains a certain item (could be used for NPC dialogue options)
     * @param itemName the name of the item
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
    /**
     * Checks if the inventory contains a certain item (could be used for NPC dialogue options)
     * instead of based on the name of the item it uses an item
     * @param item the item to check for
     * @return true if the inventory contains the item, false otherwise
     */
    public boolean containsItem(Item item)
    {
        for (ArrayList<Item> row : storage)
        {
            for (Item exist : row)
            {
                if (exist.equals(item))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
