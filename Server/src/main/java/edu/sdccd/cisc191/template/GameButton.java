package edu.sdccd.cisc191.template;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

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
}


