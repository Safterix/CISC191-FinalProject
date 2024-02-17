package edu.sdccd.cisc191.template;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Encounter extends VBox

{
    private String text;
    private Label textLabel;

    /**
     * Constructor for encounter. Adds a row of choices above text.
     * @param text the Encoutner's text
     * @param choices PlayerChoices that the player can select in the encounter
     */
    public Encounter(String text, PlayerChoice... choices)
    {
        this.text = text;

        HBox choicesRow = new HBox(choices);
        textLabel = new Label(text);
        getChildren().addAll(choicesRow, textLabel);
    }

    /**
     * Changes the Encounter's text
     * @param newText the updated text
     */
    public void updateText(String newText)
    {
        text = newText;
        textLabel.setText(text);
    }
}
