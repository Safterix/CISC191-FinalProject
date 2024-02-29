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
    ImageView icon = new ImageView(new Image("https://cdn.discordapp.com/attachments/1202075313882796082/1206410053448507422/andrew_huang.png?ex=65e5226a&is=65d2ad6a&hm=d9d627ff87f9c95e733a9b2830a69bc00ed0a7886c7f9c1e8f9d715389061b45&"));


    public Item() {
        name = "Nothing";
        description = "Empty!";

    }

    /**
     * Constructor with name
     *
     * @param name the item's name
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
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

    public GameButton displayItem(int sizeSquare) {
        GameButton itemButton = new GameButton(name, description, sizeSquare, icon);

        return itemButton;

    }
}

