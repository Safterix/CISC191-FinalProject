package edu.sdccd.cisc191.template;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * makes a label object with the font set
 */
public class GameLabel extends Label {

    public GameLabel(String text, int size, String color) {
        setText(text);
        setStyle("-fx-font-size: "+ size);
        setStyle("-fx-text-fill: "+color);
    }
    public GameLabel(String text,int size){
        setText(text);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("game-label");
        setStyle("-fx-font-size: " +size);
    }
}


