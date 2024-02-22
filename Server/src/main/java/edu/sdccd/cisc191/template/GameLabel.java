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
        fontProperty().set(new Font("Courier New", size));
        setStyle("-fx-text-fill: "+color);
    }
    public GameLabel(String text,int size){
        setText(text);
        fontProperty().set(new Font("Courier New", size));
        setStyle("-fx-text-fill: #815355");
    }
}


