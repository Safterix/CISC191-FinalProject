package edu.sdccd.cisc191.template;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Encounter extends VBox

{
    private String text;
    private Label textLabel;

    public Encounter(String text, PlayerChoice... choices)
    {
        this.text = text;

        HBox choicesRow = new HBox(choices);
        textLabel = new Label(text);
        getChildren().addAll(choicesRow, textLabel);
    }

    public void updateText(String newText)
    {
        text = newText;
        textLabel.setText(text);
    }
}
