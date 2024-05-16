package edu.sdccd.cisc191.template.ItemTypes;

import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.NPCDialog.ItemWant;
import edu.sdccd.cisc191.template.GameAssets.NPCDialog.Speech;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;

import javax.persistence.*;

/**
 * creates a general items, things you can have in an inventory
 * has a name and descrption and gameBUtton icon
// */
public class Item implements Comparable<Item> {
//

    private String name;
    private String description; //name and desc of item

    private GameButton icon; //pic of item on button
    private ItemWant want;
    /**
     * empty item conscutor that makes an empty item
     */
    public Item() {
        name = "Nothing";
        description = "Empty!";
        icon = new GameButton(this);
        want = new ItemWant(this);
        click();

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
        want = new ItemWant(this);
        click();
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
            return -1;}
        else if ((item instanceof Goods)) {
            return 1;
        }
        return 0;
    }
    public int compareTo(Goods item) {
        if(item.getName().equals(this.getName())){
            return 0;
        }
        return 1;
    }
public GameButton getIcon(){
        return icon;
}

    public void setIcon(GameButton icon) {
        this.icon = icon;
    }

    /**
     * sets icon to nothing
     */
    public void setIcon() {
        icon.setImage(new GameImageView("Nothing"));
    }

    public void giveItem(){
        if(!isNothing()){
        ViewGame.getPlayer().addScore((int) ((100)*(getWant().getMultiplier())));
       setName("Nothing");
        setDescription("Empty!");
            setIcon();}
        else if(this instanceof Goods){
            ((Goods) this).sellItem();
        }

    }
    private void click(){


        icon.setOnMouseClicked(event -> {

            if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {

                System.out.print("removedreal");
                this.giveItem();
        }
            else

            System.out.print(ViewGame.getPlayer().getScore());
                    Speech.talkAbout(this);
        });
    }

    public void getDialog(){
        getWant().getDialogText();
    }


    public ItemWant getWant() {
        return want;
    }

    public void setWant(ItemWant want) {
        this.want = want;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Item))
            return false;
        Item other = (Item) obj;
        return getName() != null && getName().equals(other.getName());
    }
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isNothing(){
        return getName().equals("Nothing");
    }
}


