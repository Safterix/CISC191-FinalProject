package edu.sdccd.cisc191.template.ItemTypes;

/**
 * goods item TODO WIP WIP
 * has value to be sold
 *
 */
public class Goods extends Item{
    private int value;
    public Goods(){
       value = 0;
        }

    public Goods(String name, String  description, int price){
        super(name,description);
        value = price;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
