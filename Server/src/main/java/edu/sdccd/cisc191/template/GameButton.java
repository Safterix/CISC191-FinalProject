package edu.sdccd.cisc191.template;

import javafx.scene.control.Button;
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
        setFont(new Font("Courier New", size));

    }

    /**
     * item SHOW BUTTON
     * @param name of item
     * @param description of item
     * @param size of button (it is square)
     * @param icon possible image
     */
    public GameButton(String name, String description, int size,  ImageView icon) {
        setText(name);
        setPrefWidth(size);
        setPrefHeight(size);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("game-button");
        setGraphic(icon);

        Tooltip hoverText = new Tooltip(description);
        hoverText.setShowDelay(Duration.seconds(0.5));
        setTooltip(hoverText);



    }
}


