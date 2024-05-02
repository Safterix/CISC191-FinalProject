package edu.sdccd.cisc191.template.ItemTypes;

import javafx.scene.layout.GridPane;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * makes inventory which is a 6x4 array list of items
 * displayed as a grid of items
 */
@Entity
public class Inventory{
    @Id
    private boolean isPlayers;
    @OneToMany(fetch = FetchType.EAGER)
    private ArrayList<Item> storage;
    @Transient
    private GridPane inventoryCells= new GridPane(); //gridpane visual of iventory with item buttons inside
    // inventory is a 2d arraylist with items
    private final int colSize = 6; int rowSize = 4; //arraylist is 6x4
    private final int size = colSize * rowSize;

    public Inventory(){
        storage= new ArrayList<Item>();
        isPlayers = true;
        for(int slot=0; slot<size;slot++){

                storage.add(new Item());
            }
        sortInv();
    }

    /**
     * adds random Nothing item to each cell, doesnt matter for now
     */
    public Inventory(boolean random){

        storage= new ArrayList<Item>();
        isPlayers = false;
        for(int slot=0; slot<size;slot++){

            storage.add(new Item(true));
        }
        sortInv();
    }

    /**
     * adds one item
     * @param item what is the item
     */
    public void addItem(Item item){
        if(!isFull()){
            storage.add(new Item());}


    }
    /**
     * reaplces one item
     * @param item what is the item
     */
    public void addItem(int col, int row, Item item){
        int location = col * rowSize + row;
        storage.set(location,item);


    }

    /**
     * checks if inventory is full, there r 24 non Nothing items
     * @return
     */
    public boolean isFull(){

        if(storage.size()==size){
            return true;
        }
        return false;
    }

    /**
     * gets item from specic row and col
     * @param row which row will item be in
     * @param col what col
     * @return the item
     */
    public Item getItem(int col, int row){
        int location = col * rowSize + row;
        return storage.get(location);
    }

    /**
     * removes one item
     * @param row which row is in
     * @param col which col
     */
    public void removeItem(int col, int row){
        int location = col * rowSize + row;
        //makes empty item in place of it
        storage.set(location,new Item());
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
                int location1 = col * rowSize + row;
                inventoryCells.add(storage.get(location1).displayItem(),col,row,1,1);

            }
        }
    return inventoryCells;

    }

    /**
     * TODO attempt at sorting inv items
     */
    public void sortInv(){

            Collections.sort(storage,Item::compareTo);

    }
    public boolean isEmpty(){

            for(Item item: storage){
            if(!item.getName().equals("Nothing")){
                return false;
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
            for (Item item : storage)
            {
                if (item.getName().equals(itemName))
                {
                    return true;
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
            for (Item exist : storage)
            {
                if (exist.equals(item))
                {
                    return true;
                }
        }

        return false;
    }
    public Item getItemIn(int col, int row){
        int location = col * rowSize + row;
        return storage.get(location);
    }

    public ArrayList<Item> getAllItems(){
        return storage;
    }
}
