package edu.sdccd.cisc191.template.ItemTypes;

import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * iitems TODO WIP make displayItem() acutalyl show a picture lol
 * also what items would be there that are not goods? (some expampels pls)
 */
public class Item {
    private String name, description;
    GameButton icon;

    public Item() {
        name = "Nothing";
        description = "Empty!";
        icon = new GameButton(this);

    }

    public Item(boolean random){
        //only pics from china rn
        Item randomItem = new Consumable(Consumable.china);
       name = randomItem.getName();
       description =randomItem.getDescription();
       icon = new GameButton(this);
    }
    /**
     * Constructor with name
     *
     * @param name the item's name
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        icon= new GameButton(this);
    }

    /**
     * Uses the item
     *
     * @param character the character who is using the item
     */
    public void useItem(Character character) //maybe make this abstract so that each type of item has to implement it separately?
    {
        //do stuff
    }

    /**
     * @return item name
     */
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameButton displayItem() {
        return icon;

    }
}

