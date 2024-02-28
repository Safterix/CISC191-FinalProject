package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameLabel;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class NPC extends Character {
    private String name; //name of the character
    private String description; // descrption of charcater
    private int money; //amount of money they have
    private int health; // amount of hp they have
    private final int MAX_HEALTH = 100;
    private short reputation; // reputation from [-100,100]
    private Inventory storage; //TODO decide on how inventory size works

    public NPC(String name, int money, int health, short rep, String description) {
        super(name, money, health, rep);
        this.description = description;

    }

    public void changeName(String newName) {
        name = newName; //this is for when you ahve a "Mysterious Man" and you reveal who they are i guess
    }


    public GridPane displayProfile() {
        //TODO stats are hidden so it will just be Name, ToolTip description, and Image
        //only options should reveal their HP MONEY or INVEN

        return new GridPane();


    }
    public GameLabel showHealth(){
        GameLabel health = new GameLabel("Health: "+ getHealth() +"/"+ getMAX_HEALTH(),20,"#AA0C0C");
        return health;
    }
    public GameLabel showMoney(){
        GameLabel money = new GameLabel("Money: "+ getMoney(),20, "#9FB425");
        return money;
    }
}

