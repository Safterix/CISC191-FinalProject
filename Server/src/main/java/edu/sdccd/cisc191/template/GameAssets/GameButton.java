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
        setPrefWidth(width);
        setPrefHeight(height);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("game-button");
        setStyle("-fx-font-size: "+ size);

    }

    /**
     * item  BUTTON
     * @param name of item
     * @param description of item
     * @param size of button (it is square)
     */
    public GameButton(String name,String description, int size) {
        setText(name);
        setPrefWidth(size);
        setPrefHeight(size);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("item-button");
        setGraphic(new GameImageView(name));
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setStyle("-fx-font-size: "+ size/5);
        Tooltip hoverText = new Tooltip(description);
        hoverText.setStyle("-fx-font-size: "+ size/3);

        setTooltip(hoverText);



    }
}


