package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * GameImageView extends ImageView and displays an image in various ways
 * it fits with the aspect ratio and sizes of the screen
 * can be used to display an image a third of the screen
 * display tiny image for item
 * display emotion icon for NPCs
 */
public class GameImageView extends ImageView {
    /**
     * for NPC body sprites, fits a third of the screen
     * @param image of the npc sprite, or any image that is a third fo the screen and square
     */
    public GameImageView (Image image){
    super(image); // makes imageview
    //makes it fit a third of the screen
    setFitHeight(ViewGame.getScreenDimensions()*9/48);
    setFitWidth(ViewGame.getScreenDimensions()*9/48);
    }

    /**
     * THIS IS FOR ITEMS ONLY
     * makes an imageview base don the name of an item
     * @param name of the item
     */
    public GameImageView(String name){
    //sets image size for item
        super(new Image("image/items/"+name+".png"));
        setFitHeight(ViewGame.getScreenDimensions()*9/192-ViewGame.getScreenDimensions()*25/1280);
        setFitWidth(ViewGame.getScreenDimensions()*9/192-ViewGame.getScreenDimensions()*25/1280);

    }

    /**
     * THIS IS FOR THE NPC EMOTION ONLY
     * makes a tiny image that is a 12th of the screen that goes in the NPC name dialog
     * @param speakerName the speaker
     * @param mood the mood of the sprite
     */
    public GameImageView (String speakerName, String mood){
        super(new Image("image/Sprites/"+speakerName+"_"+mood+".png"));
        //makes it fit a twelvth of the screen
        setFitHeight(ViewGame.getScreenDimensions()/12);
        setFitWidth(ViewGame.getScreenDimensions()/12);
        //makes a gametooltip so when you hover overthe sprite it says the emotion theyre feeling
        GameTooltip emotion = new GameTooltip(mood);
        GameTooltip.install(this,emotion);
    }
}
