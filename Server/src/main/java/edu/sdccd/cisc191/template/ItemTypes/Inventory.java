package edu.sdccd.cisc191.template.ItemTypes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.GridPane;

import javax.persistence.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * makes inventory which is a 6x4 array list of items
 * displayed as a grid of items
 */
public class Inventory{
    private boolean isPlayers;
    private ArrayList<Item> storage;
    private GridPane inventoryCells= new GridPane(); //gridpane visual of iventory with item buttons inside
    // inventory is a 2d arraylist with items
    private final int colSize = 6; int rowSize = 4; //arraylist is 6x4
    private final int size = colSize * rowSize;
    private static boolean uptodate;

    public Inventory(){
        storage= new ArrayList<Item>();
        isPlayers = true;
        for(int slot=0; slot<size;slot++){

                storage.add(new Item());
            }
        uptodate =true;

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
        uptodate =true;

    }

    /**
     * adds one item
     * @param item what is the item
     */
    public void addItem(Item item){

        if(!isFull()){
        System.out.print("is padded");
            storage.remove(findSpace());
            storage.add(item);
            System.out.print(this);
        }
        uptodate =false;

    }

    public Item findSpace(){
        for(int slot=0; slot<size;slot++){
            if(storage.get(slot).isNothing()){
            return storage.get(slot);}
        }
        return null;
    }
    /**
     * reaplces one item
     * @param item what is the item
     */
    public void addItem(int col, int row, Item item){
        int location = col * rowSize + row;
        storage.set(location,item);
        uptodate =false;


    }

    /**
     * checks if inventory is full, there r 24 non Nothing items
     * @return
     */
    public boolean isFull(){
        int count = 0;

        for(Item item:storage){
            if(!item.isNothing()){
                count++;
            }
        }


        return count == size;
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
        uptodate =false;
    }
    /**
     * removes one item
     * @param itemREmove item that will be removed
     */
    public void removeItem(Item itemREmove){
        //makes empty item in place of it
        storage.remove(itemREmove);
        storage.add(new Item());
        uptodate =false;

    }




    /**
     * displays the inventory on a gridpane of buttons
     * @return gridpane of buttons, visual of inventory
     */
    public GridPane displayInventory(){
        uptodate =true;
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

    /**
     *
     * checks if the inventory is empty
     * @return if is empty or not
     */
    public boolean isEmpty(){
        int empty = 0;

        for(Item item:storage){
            if(item.isNothing()){
                empty++;
            }
        }


        return empty == size;
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

    /**
     *
     * @param col item is in
     * @param row item is in
     * @return item in col,row
     */
    public Item getItemIn(int col, int row){
        int location = col * rowSize + row;
        return storage.get(location);
    }

    /**
     *
     * @return all items in list
     */
    public String toString(){
        String allItems = "";
        for(Item item :storage){
               allItems += " "+ item.getName();
            }
        return allItems;
    }

    /**
     *
     * @return arraylist of items
     */
    public ArrayList<Item> getAllItems(){
        return storage;
    }

    /**
     * checks if is upt o date
     * @return
     */
    public boolean isUptodate(){
        return uptodate;
}
}
