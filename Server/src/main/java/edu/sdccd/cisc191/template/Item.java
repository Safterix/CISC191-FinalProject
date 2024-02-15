package edu.sdccd.cisc191.template;

public class Item
{
    private String name;

    /**
     * Constructor with name
     * @param name the item's name
     */
    public Item(String name)
    {
        this.name = name;
    }

    /**
     * Uses the item
     * @param character the character who is using the item
     */
    public void useItem(Character character) //maybe make this abstract so that each type of item has to implement it separately?
    {
        //do stuff
    }

    /**
     * @return item name
     */
    public String getName()
    {
        return name;
    }

}
