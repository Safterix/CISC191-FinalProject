package edu.sdccd.cisc191.template.ItemTypes;

public class ItemNode {
    Item item;
    int count;
    ItemNode leftChild;
    ItemNode rightChild;

    public ItemNode(Item item){
        this.item = item;
        count =1;
    }

    public Item getItem(){
        return item;
    }

    @Override
    public String toString() {
        return (item.getName()+" " +count+" ");
    }

    public void addCount() {
        count++;
    }
}
