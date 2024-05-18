package edu.sdccd.cisc191.template.ItemTypes;

import java.util.ArrayList;

public class SortInventory extends Thread {
     final private ArrayList<edu.sdccd.cisc191.template.ItemTypes.Item> inventory;
    private ArrayList<ItemNode> allItemNodes;
    private ItemNode root;

    /**
     * constructor that makes a SortInventory
     * flattens inventory into an ArrayList
     * @param inventory that will be flattened and sorted
     */
    public SortInventory(Inventory inventory){
        //gets 2d arraylist of inv
        this.inventory=inventory.getAllItems();
        //initallize allItemNodes and allItemsFlattened
        allItemNodes = new ArrayList<>();

        System.out.println("Og Size: "+this.inventory.size());
    }

    public void run(){

        convertToNode(null);
    }
    /**
     * converts the allItemsFlattened Item ArrayList to ItemNode ArrayList
     * @param preDup the array that will be gone through
     */
    public void convertToNode(ArrayList<Item> preDup) {
        //makes preDuplicatesCopy
        ArrayList<Item> preDuplicatesCopy;
        //if it is null, preDuplicatesCopy is allItemsFlattened clone
        if (preDup == null) {
            preDuplicatesCopy = (ArrayList<Item>) inventory.clone();
            System.out.println("Clone size: "+preDuplicatesCopy.size());}
        else {preDuplicatesCopy=preDup;}
        if(!preDuplicatesCopy.isEmpty()) {
            //get an item from the start
            ItemNode focus = new ItemNode(preDuplicatesCopy.remove(0));
            System.out.println("Target: " + focus);
            //go thru the rest of the array, checking if there are duplicates of the item
            //if it is equal, add one count to the itemNode and remove from preDuplicatesCopy
            int i = 0;
            while (i < preDuplicatesCopy.size()) {
                //if items are the same add one and remove that item from the list
                if (!preDuplicatesCopy.get(i).equals((focus.getItem()))) {
                    System.out.println(i + "Not Doop: " + preDuplicatesCopy.get(i).getName());
                    i++;}
                //else dont remove it but add 1 to i to go to the next
                else {
                    focus.addCount();
                    preDuplicatesCopy.remove(i);
                    System.out.println(i + "Doop: " + focus);}}
            //add the item with the count to  allItemNodes
            allItemNodes.add(focus);}
        if(!preDuplicatesCopy.isEmpty()){
        convertToNode(preDuplicatesCopy);}}

    /**
     * noargs addNodes which inputs the allItemNodes
     */
    public void addNodes(){
        while(!allItemNodes.isEmpty()){
            addNodes(allItemNodes);
        }
    }

    /**
     * make a binary search tree out of the ItemNode arraylist that already
     * has duplicates dealt with
     * @param arrayList arraylist with duplicates dealt with
     */
    public void addNodes(ArrayList<ItemNode> arrayList){
        ItemNode focus, parent;
            //new node becomes the first item in list, remove it from list
        ItemNode newItemNode = arrayList.remove(0);
        //if the root doesnt have anything, the new item is the root
        if (root==null){
            root = newItemNode;
        }

        //but if root already has something
        else{
            //start from the root
           focus = root;
            //do processes until u return...
            while(!(newItemNode ==null)){
                //set parent to focus/root
                parent = focus;
                //if the new item is less than the focus item
                    if(newItemNode.getItem().compareTo(focus.getItem()) < 0){
                        //focus becomes the left child
                    focus = focus.leftChild;
                    //if focus(now left child) is null
                    if(focus ==null){
                        //it is the new item
                        parent.leftChild= newItemNode;
                        return;

                    }
                      }
                //if its greater/ equal it goes on the right
                else{
                    //focus becomes right child
                    focus =focus.rightChild;
                    //if focus (now right) doesnt exist
                    if(focus==null){
                        //it is new item
                        parent.rightChild= newItemNode;
                        return;
                    }

                }
        }}
        //if allItemsNodes is not empty, recursive
        while(!arrayList.isEmpty()){
            addNodes(arrayList);
        }
    }


    /**
     * prints out the tree in correct order , least to greatest
     * @param focus
     */
    public String inOrderTraverse(ItemNode focus){
        //if the starting poitn is not null
       if(focus!=null){
           //go thru the left side
           inOrderTraverse(focus.leftChild);
           System.out.print(focus+" ");
            //go thru right side
           inOrderTraverse(focus.rightChild);
           return (focus+" ");
       }
        return null;
    }

    /**
     *
     * @return root of tree
     */
    public ItemNode getRoot(){
        return root;
    }

    }


