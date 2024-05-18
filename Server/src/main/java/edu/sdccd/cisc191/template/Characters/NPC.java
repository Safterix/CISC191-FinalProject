package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.DataBaseApplication;
import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.GameTooltip;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.DataBaseApplication;
import javafx.scene.image.Image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import static edu.sdccd.cisc191.template.DataBaseApplication.randomNPC;

/**
 * creates an npc with everything in character, a descrption ,and body sprite
 */
@Entity

public class NPC extends Character {

    private String description; // descrption of charcater
    @Transient
    private Personality personality;
    @Transient
    private GameImageView bodySprite; // half body sprite u see of them
        public enum Personality{
            angry,excited,happy,indifferent,nervous,neutral,silly
        }

    /**
     * makes an NPC
     * TODO this just makes Tao Yu for now
     */
    public NPC(){
        super("Marky",0,100,0);
        description = "...";
        personality=Personality.happy;
        bodySprite = new GameImageView(new Image("image/Sprites/"+getName().replaceAll("\\s", "")+"_body1.png"));
    }
    public NPC(boolean random){
        super(randomNPC().getName(),randomNPC().getMoney(),randomNPC().getHealth(),randomNPC().getReputation());
        description = randomNPC().getDescription();
        personality = randomNPC().getPersonality();
        bodySprite = new GameImageView(new Image("image/Sprites/"+getName().replaceAll("\\s", "")+"_body1.png"));

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
        bodySprite = new GameImageView(new Image("image/Sprites/"+getName().replaceAll("\\s", "")+"_body1.png"));
        personality = Personality.happy;

    }

    public String getDescription() {
        return description;
    }

    /**
     * displays the NPC's profile, which is their picture
     * tooltip over to see their descrption
     * @return image sprite of NPC
     */
    public GameImageView displayProfile() {

        GameTooltip desc = new GameTooltip(description);
        bodySprite.setFitWidth(ViewGame.getScreenDimensions()/3);
        bodySprite.setFitHeight(ViewGame.getScreenDimensions()/3);

        GameTooltip.install(bodySprite,desc);
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
    @Override
    public String toString(){
        return getName() + " " + getMoney() + " " + getHealth() + " " + getReputation();
    }


    public void setDescription(String description){
        this.description =description;
    }
}

