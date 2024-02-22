package edu.sdccd.cisc191.template.ItemTypes;

import edu.sdccd.cisc191.template.Characters.Character;

public class Item
{
    private String name,  description;

    public Item(){
        name = "";
        description = "empty!";
    }
    /**
     * Constructor with name
     * @param name the item's name
     */
    public Item(String name, String  description)
    {
        this.name = name;
        this.description =description;
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
    public String getDescription(){return description;}

    }
}
