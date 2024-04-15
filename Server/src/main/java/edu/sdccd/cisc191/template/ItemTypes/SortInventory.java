package edu.sdccd.cisc191.template.ItemTypes;

import java.util.ArrayList;

public class SortInventory{
     final private ArrayList<ArrayList<edu.sdccd.cisc191.template.ItemTypes.Item>> inventory;
    private ArrayList<Item> allItemsFlattened;
    private ItemNode root;


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
        while(!allItemsFlattened.isEmpty()){
            addNodes(allItemsFlattened);
        }
    }
    public void addNodes(ArrayList<Item> arrayList){
        ItemNode focus, parent;
            //new node becomes the first item
        ItemNode newItemNode = new ItemNode(arrayList.remove(0));

        //if the root doesnt have anything, the root is the new item
            //and remove the first item
        if (root==null){
            root = newItemNode;
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
               //TODO IDK WHY DOESNT WORK... makes a count if theres multple of same item
//                if(newItemNode.getItem().compareTo(focus.getItem())==0){
//                    focus.addCount();
//                    return;
//                }
//                else
                    if(newItemNode.getItem().compareTo(focus.getItem()) == -1){
                    focus = focus.leftChild;
                    //if left child is null
                    if(focus.leftChild ==null){
                        parent.leftChild= newItemNode;
                        return;

                    }
                }
                //if its greater/ equal it goes on the right
                //remove it from list
                else{
                    focus =focus.rightChild;
                    //but if the right child doesnt exist
                    //make the newNode the right child and remove
                    if(focus==null){
                        parent.rightChild= newItemNode;
                        return;
                    }
                }
            }
        }}



    public void inOrderTraverse(ItemNode focus){
       if(focus!=null){
           inOrderTraverse(focus.leftChild);
           System.out.print(focus+" ");

           inOrderTraverse(focus.rightChild);
       }
    }
    public ItemNode getRoot(){
        return root;
    }

    }


