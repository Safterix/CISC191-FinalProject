package edu.sdccd.cisc191.template;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameButton extends Button {

    /**
     * creates buttons with presets for the main menu of the game
     * @param name the text displayed on the button
     * @param width prefered width size of the button
     * @param height perfered hegiht size of the button
     * @param color the color the text of the button will be
     */
    public GameButton(String name, int width, int height, String color){
    setText(name);
    setPrefWidth(width);
    setPrefHeight(height);
    setStyle("-fx-text-fill: "+color);

        fontProperty().set(new Font("Times New Roman",40));
    }

    public GameButton(String name, int width, int height) {
        setText(name);
        setPrefWidth(width);
        setPrefHeight(height);
        setStyle("-fx-text-fill: #815355" );
        setStyle("-fx-background-color: #CBD4C2");
        setStyle("-fx-border-color: #523249");
        setStyle("-fx-border-width: 5");
        fontProperty().set(new Font("Times New Roman",40));
    }
}


