package edu.sdccd.cisc191.template.ItemTypes;

import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * creates a general items, things you can have in an inventory
 * has a name and descrption and gameBUtton icon
 */
public class Item implements Comparable<Item> {
    private String name, description; //name and desc of item
    GameButton icon; //pic of item on button

    /**
     * empty item conscutor that makes an empty item
     */
    public Item() {
        name = "Nothing";
        description = "Empty!";
        icon = new GameButton(this);

    }

    /**
     * constroctor that makes a random item
     * TODO RN JUST GENERATES CHINA ITEMS
     * @param random
     */
    public Item(boolean random){
        //only pics from china rn
        Item randomItem = new Consumable(Consumable.china);
       name = randomItem.getName();
       description =randomItem.getDescription();
       icon = new GameButton(this);
    }

    /**
     * Uses the item TODO
     *
     * @param character the character who is using the item
     */
    public void useItem(Character character) //maybe make this abstract so that each type of item has to implement it separately?
    {
        //do stuff TODO
    }

    /**
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * @return item descrption
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param name sets name of item, used by Goods and consumable classes
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @param description sets description of item, used by Goods and consumable classes
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return gamebutton, the little item square
     */
    public GameButton displayItem() {
        return icon;

    }

    /**
     * checks to see if two items are equal based on their names
     * @param item that isbeing compared to
     * @return true or false if they are equal
     */
    public boolean equals(Item item){
        return this.getName().equals(item.getName());
    }
    /**
     * compares to see if item is less, greater, or eqwual
     * @param item the object to be compared.
     * @return 0
     */
    @Override
    public int compareTo(Item item) {
        if(item.getName().equals("Nothing")){
            return 1;}
        else if (((Item) item).getClass().toString().equals("Goods")) {
            return -1;
        }
        return 0;
    }
}


