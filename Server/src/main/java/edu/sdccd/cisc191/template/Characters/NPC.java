package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.GameTooltip;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.scene.image.Image;

/**
 * creates an npc with everything in character, a descrption ,and body sprite
 */
public class NPC extends Character {
    private String description; // descrption of charcater
    private Personality personality;
    private GameImageView bodySprite; // half body sprite u see of them
        public enum Personality{
            angry,excited,happy,indifferent,nervous,neutral,silly
        }

    /**
     * makes an NPC
     * TODO this just makes Tao Yu for now
     */
    public NPC(){
        super("Tao Yu",100,100, (short) 50);
        description = "Mysterious";
        //adds their image sprite based on heir name, but without any spaces
        bodySprite = new GameImageView(new Image("image/Sprites/"+getName().replaceAll("\\s", "")+"_body1.png"));
        personality = Personality.happy;


    }

    /**
     * makes NPC with specific name and stats
     * @param name of npc
     * @param money that npc has
     * @param health of npc
     * @param rep of npc
     * @param description of npc
     */
    public NPC(String name, int money, int health, short rep, String description) {
        super(name, money, health, rep);
        this.description = description;

    }

    /**
     * displays the NPC's profile, which is their picture
     * tooltip over to see their descrption
     * @return image sprite of NPC
     */
    public GameImageView displayProfile() {

        GameTooltip desc = new GameTooltip(description);
        GameTooltip.install(bodySprite,desc);
        bodySprite.setFitWidth(ViewGame.getScreenDimensions()/3);
        bodySprite.setFitHeight(ViewGame.getScreenDimensions()/3);
        return bodySprite;


    }

    /**
     * reveal the health of npc, normally hidden
     * @return health of npc
     */
    public GameLabel showHealth(){
        return new GameLabel("Health: "+ getHealth() +"/"+ getMAX_HEALTH(),20,"#AA0C0C");

    }
    /**
     * reveal the money of npc, normally hidden
     * @return money of npc
     */
    public GameLabel showMoney(){
        return new GameLabel("Money: "+ getMoney(),20, "#9FB425");

    }

    public Personality getPersonality() {
        return personality;
    }


    public void setDescription(String description){
        this.description =description;
    }
}

