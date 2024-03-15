package edu.sdccd.cisc191.template.GameAssets;

import javafx.scene.control.Tooltip;
import javafx.util.Duration;

/**
 * gametooltip that extends tooltip, has default styles (background, border and font)
 *
 */
public class GameTooltip extends Tooltip {
/**
 * makes tooltip with preset background and border for an NPC descprtion or any thing
 * default gametOOltip
 * @param NPCDesc the text that wil be displayed
 */
    public GameTooltip(String NPCDesc){
        setText(NPCDesc);
        setStyle("-fx-font-size: "+ViewGame.getScreenDimensions()/60+";-fx-background-color: #CBD4C2; -fx-border-color: #523249;"+
                "-fx-text-fill: #815355; -fx-border-width: 5");
        //makes it so it takes 20milisec for the tool tip to appear
        setShowDelay(Duration.millis(20));
    }

    /**
     * FOR ITEM DESCRPTION
     * same deafult backgrund color and border just smaller font
     * @param item determines if it is an item... can be true or false doesnt matter...
     * @param desc descrption of the item that will be displayed on the tooltip
     */
    public GameTooltip(boolean item, String desc){
        setText(desc);
        setStyle("-fx-font-size: "+ViewGame.getScreenDimensions()/45+";-fx-background-color: #CBD4C2; -fx-border-color: #523249;"+
                "-fx-text-fill: #815355; -fx-border-width: 5");
        //makes it so it takes 20milisec for the tool tip to appear
        setShowDelay(Duration.millis(20));
    }
}
