package edu.sdccd.cisc191.template;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Encounter

{
    private String text;
    private Label textLabel;
    private GameButton[] choices;

    /**
     * Constructor for encounter. Adds a row of choices above text.
     * @param text the Encoutner's text
     * @param choices PlayerChoices that the player can select in the encounter
     */
    public Encounter(String text, GameButton... choices)
    {
        this.text = text;
        textLabel = new Label(text);

        this.choices = choices;
    }

    public GameButton[] getChoices()
    {
        return choices;
    }

    public Label getTextLabel()
    {
        return textLabel;
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
