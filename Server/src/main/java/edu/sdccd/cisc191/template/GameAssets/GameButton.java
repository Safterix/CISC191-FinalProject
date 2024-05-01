package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;

/**
 * Gamebutton extends button and makes a presetted button in various ways
 * can be used for any text label
 * can be used to display item
 */
public class GameButton extends Button {


    /**
     * default button with text label
     * @param name the text displayed on the button
     * @param width prefered width size of the button
     * @param height perfered hegiht size of the button
     * @param size size of the font
     */
    public GameButton(String name, int width, int height, int size) {
        //sets text to what you want to be displayed
        setText(name);
        setPrefSize(width,height);
        setMaxSize(width,height);
        //add style border, backgorund, font
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("game-button");
        setStyle("-fx-font-size: "+ size);

    }

    /**
     * item  BUTTON, makes button with item, gets the name and desc of item
     * @param item the item
     */
    public GameButton(Item item) {
        //no text b/c u cant even see it
        //sets icon size based on screen dimensions
        setPrefSize(ViewGame.getScreenDimensions()*9/192,ViewGame.getScreenDimensions()*9/192);
        setMaxSize(ViewGame.getScreenDimensions()*9/192,ViewGame.getScreenDimensions()*9/192);
        //add css style, border, background.
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("item-button");
        //sets picture to icon fo the game
        setGraphic(new GameImageView((item.getName())));
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        //tool tip that when you hoverr it has the descriptioin of the item
        GameTooltip hoverText = new GameTooltip(true,item.getDescription());
        setTooltip(hoverText);



    }
}


