package edu.sdccd.cisc191.template.GameAssets;

import javafx.scene.control.TextArea;

public class GameTextArea extends TextArea {
        int width= ViewGame.getScreenDimensions();
      public GameTextArea(String text, String mood){
            setText(text);
            getStylesheets().add("colorPalette.css");
            getStyleClass().add("text-area");
            getStyleClass().add(mood+"-label");
            setEditable(false);
            setMaxSize(width/3,width/48*9);
           setStyle("-fx-font-size: "+ width/20);
        }

    public GameTextArea(String text){
        setText("\t"+text);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("text-area");
        getStyleClass().add("game-label");
        setEditable(false);
    }
        public void changeMood(String mood){
          getStyleClass().add(mood+"-label");
        }

    }

