package edu.sdccd.cisc191.template.GameAssets;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * makes a label object with the font set
 */
public class GameLabel extends Label {

    public GameLabel(String text, int size, String color) {
        setText(text);getStylesheets().add("colorPalette.css");
        getStyleClass().add(color+"-label");
        setStyle("-fx-font-size: " +size);
    }
    public GameLabel(String text,int size){
        setText(text);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("game-label");
        setStyle("-fx-font-size: " +size);
    }
}


