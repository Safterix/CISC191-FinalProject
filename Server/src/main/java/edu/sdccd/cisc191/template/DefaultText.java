package edu.sdccd.cisc191.template;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * makes a label object with the font set
 */
public class DefaultText extends Label {
    public DefaultText(String text, int size, Color color) {
        setText(text);
        fontProperty().set(new Font("Times New Roman", size));
        setTextFill(color);
    }
}


