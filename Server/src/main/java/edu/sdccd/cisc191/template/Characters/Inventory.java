package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class Inventory {
    private Item[][] storage = new Item[6][4];

    public Inventory(){
        for(int row=0; row<storage.length;row++){
            for(int col=0;col<storage[row].length;col++){
                //adds Empty item in each cell
                storage[row][col]= new Item();

            }
        }
    }
    public void addItem(int row, int col, Item item){
        storage[row][col]= item;
    }
    public void removeItem(int row, int col){
        //empty item
        storage[row][col]= new Item();
    }

    public GridPane displayInventory(int itemSize){
        GridPane inventoryCells = new GridPane();
        for(int row=0; row<storage.length;row++){
            for(int col=0;col<storage[row].length;col++){
                //adds everycell
                inventoryCells.add(storage[row][col].displayItem(itemSize),row,col,1,1);

            }
        }
    return inventoryCells;

    }
}
