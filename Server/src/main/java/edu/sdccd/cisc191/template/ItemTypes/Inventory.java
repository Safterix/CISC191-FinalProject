package edu.sdccd.cisc191.template.ItemTypes;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.layout.GridPane;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;

/**
 * makes inventory which is a 6x4 array list of items
 * displayed as a grid of items
 */
public class Inventory{
    private ArrayList<ArrayList<Item>> storage= new ArrayList<ArrayList<Item>>();
    private GridPane inventoryCells= new GridPane(); //gridpane visual of iventory with item buttons inside
    // inventory is a 2d arraylist with items
    private final int colSize = 6; int rowSize = 4; //arraylist is 6x4
    public Inventory(){

        for(int col=0; col<colSize;col++){
            //make the rows
            storage.add(new ArrayList<Item>());
            for(int row=0;row<rowSize;row++){
                //adds default Nothing item in each cell
                storage.get(col).add(new Item());

            }
        }
        sortInv();
    }

    /**
     * adds random Nothing item to each cell
     */
    public Inventory(boolean random){

        for(int col=0; col<colSize;col++){
            //make the rows
            storage.add(new ArrayList<Item>());
            for(int row=0;row<rowSize;row++){
                //adds random item in each cell
                storage.get(col).add(new Item(true));

            }

        }
        sortInv();
    }

    /**
     * adds one item
     * @param col which row will item be in
     * @param item what is the item
     */
    public void addItem(int col, Item item){
            for(int i=0; i<colSize;i++){
                if(rowIsEmpty(i))
                    storage.get(col).add(item);
                }
    }
    /**
     * adds one item, replaces actaully
     * @param row which row will item be in
     * @param col what col is the item being removed from
     * @param item what is the item
     */
    public void addItem(int col, int row, Item item){

                storage.get(col).remove(row);
                storage.get(col).add(item);
        }
    /**
     * gets item from specic row and col
     * @param row which row will item be in
     * @param col what col
     * @return the item
     */
    public Item getItem(int col, int row){

        return storage.get(col).get(row);
    }
    /**
     * gets col
     * @param col the row that you want to get
     * @return the col arraylist
     */
    public ArrayList<Item> getCol(int col){

        return storage.get(col);
    }
    /**
     * removes one item
     * @param row which row is in
     * @param col which col
     */
    public void removeItem(int col, int row){
        //makes empty item in place of it
        storage.get(col).remove(row);
        storage.get(col).add(new Item());
        sortInv();
    }

    /**
     * displays the inventory on a gridpane of buttons
     * @return gridpane of buttons, visual of inventory
     */
    public GridPane displayInventory(){
        sortInv();
        inventoryCells.getChildren().removeAll();
        for(int col=0; col<colSize;col++){
            for(int row=0;row<rowSize;row++){
                //adds everycell

                inventoryCells.add(storage.get(col).get(row).displayItem(),col,row,1,1);

            }
        }
    return inventoryCells;

    }

    /**
     * TODO attempt at sorting inv items
     */
    public void sortInv(){

        for(ArrayList<Item> col: storage){
            Collections.sort(col,Item::compareTo);
            }

    }
    public boolean rowIsEmpty(int col){

        if(col<colSize){
            for(Item item: storage.get(col)){
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
        for (ArrayList<Item> col : storage)
        {
            for (Item item : col)
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
        for (ArrayList<Item> col : storage)
        {
            for (Item exist : col)
            {
                if (exist.equals(item))
                {
                    return true;
                }
            }
        }

        return false;
    }
    public Item getItemIn(int col, int row){
        return storage.get(col).get(row);
    }

    public ArrayList<ArrayList<Item>> getAllItems(){
        return storage;
    }
}
