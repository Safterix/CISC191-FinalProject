package edu.sdccd.cisc191.template.ItemTypes;

import javafx.embed.swing.JFXPanel;

import java.util.ArrayList;
import java.util.Iterator;

public class SortInventory{
    private ArrayList<ArrayList<edu.sdccd.cisc191.template.ItemTypes.Item>> inventory;
    private ArrayList<Item> allItemsFlattened;
    private Node root;


    public SortInventory(Inventory inventory){

        this.inventory=inventory.getAllItems();

        allItemsFlattened = new ArrayList<>();
        for(ArrayList<Item> col: this.inventory){
            allItemsFlattened.addAll(col);
        }}
    public void reset(){
        for(ArrayList<Item> col: inventory){
            allItemsFlattened.addAll(col);
    }}
    public void addNodes(){

        if(!allItemsFlattened.isEmpty()){
            addNodes(allItemsFlattened);
        }
    }
    public void addNodes(ArrayList<Item> arrayList){
        Node focus, parent;
            //new node becomes the first item
        Node newNode = new Node(arrayList.get(0));
        arrayList.remove(0);
        //if the root doesnt have anything, the root is the new item
            //and remove the first item
        if (root==null){
            root =newNode;
            //go add things again
            //this makes root real
        }

        //but if root already has something
        else{
            //start from the root
           focus = root;
            //do processes
            while(!allItemsFlattened.isEmpty()){
                //go to the parent
                parent = focus;
                //if the current item in is less than the one in parent,
                //put it on the left and remove it from the list
                if(newNode.getItem().compareTo(focus.getItem()) < 0){

                    //if left child is null
                    if(focus.leftChild ==null){
                        parent.leftChild= newNode;

                    }
                }
                //if its greater/ equal it goes on the right
                //remove it from list
                else{
                    focus =focus.rightChild;
                    //but if the right child doesnt exist
                    //make the newNode the right child and remove
                    if(focus==null){
                        parent.rightChild=newNode;
                    }
                }
            }
        } }



    public void inOrderTraverse(Node focus){
       if(focus!=null){
           inOrderTraverse(focus.leftChild);
           System.out.print(focus);

           inOrderTraverse(focus.rightChild);
       }
    }
    public Node getRoot(){
        return root;
    }

    }


