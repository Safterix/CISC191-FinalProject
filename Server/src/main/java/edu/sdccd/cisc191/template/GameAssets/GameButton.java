package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;

import javax.tools.Tool;

public class GameButton extends Button {


    /**
     * default button with text label
     * @param name the text displayed on the button
     * @param width prefered width size of the button
     * @param height perfered hegiht size of the button
     * @param size size of the font
     */
    public GameButton(String name, int width, int height, int size) {
        setText(name);
        setPrefSize(width,height);
        setMaxSize(width,height);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("game-button");
        setStyle("-fx-font-size: "+ size);

    }

    /**
     * item  BUTTON
     * @param item the item
     */
    public GameButton(Item item) {
        setText(item.getName());
        //sets size to correct size on page..... image on item...
        setPrefSize(ViewGame.getScreenDimensions()*9/192,ViewGame.getScreenDimensions()*9/192);
        setMaxSize(ViewGame.getScreenDimensions()*9/192,ViewGame.getScreenDimensions()*9/192);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("item-button");
        setGraphic(new GameImageView((item.getName())));
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        GameTooltip hoverText = new GameTooltip(true,item.getDescription());

        setTooltip(hoverText);



    }
}


