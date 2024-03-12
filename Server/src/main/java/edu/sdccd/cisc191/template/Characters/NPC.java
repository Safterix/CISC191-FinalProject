package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.GameTooltip;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class NPC extends Character {
    private String name; //name of the character
    private String description; // descrption of charcater
    private GameImageView bodySprite;
    private short reputation; // reputation from [-100,100]



    public NPC(){
        super("Tao Yu",100,100, (short) 50);
        description = "Mysterious";
        bodySprite = new GameImageView(new Image("image/Sprites/"+getName().replaceAll("\\s", "")+"_body1.png"));



    }
    public NPC(String name, int money, int health, short rep, String description) {
        super(name, money, health, rep);
        this.description = description;

    }

    public void changeName(String newName) {
        name = newName; //this is for when you ahve a "Mysterious Man" and you reveal who they are i guess
    }


    public GameImageView displayProfile() {

        GameTooltip desc = new GameTooltip(description);
        GameTooltip.install(bodySprite,desc);
        bodySprite.setFitWidth(ViewGame.getScreenDimensions()/3);
        bodySprite.setFitHeight(ViewGame.getScreenDimensions()/3);
        return bodySprite;


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

