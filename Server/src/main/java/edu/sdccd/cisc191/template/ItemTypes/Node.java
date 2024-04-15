package edu.sdccd.cisc191.template.ItemTypes;

public class Node{
    Item item;
    Node leftChild;
    Node rightChild;

    public Node(Item item){
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

    @Override
    public String toString() {
        return item.getName();
    }
}
