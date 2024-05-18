package edu.sdccd.cisc191.template.GameAssets;

import javafx.scene.control.Label;
/**
 * makes a label object with the font set
 * can make default brownish font with default pixel font (game-label)
 * or any other font styles in the CSS file (fancy, red, angry, etc)
 */
public class GameLabel extends Label {
    /**
     * makes a label that is formated correctly with its font,size and color
     * @param text the text that will be displayed
     * @param size the size of the text
     * @param color the color (or mood/font style) of the font
     */
    public GameLabel(String text, int size, String color) {
        setText(text);getStylesheets().add("colorPalette.css");
        getStyleClass().add(color+"-label");
        setStyle("-fx-font-size: " +size);
    }

    /**
     * makes a default label with the default font color and style
     * @param text tthe text that will be displayed
     * @param size the font size
     */
    public GameLabel(String text,int size){
        setText(text);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("game-label");
        setStyle("-fx-font-size: " +size);
    }


}


