package edu.sdccd.cisc191.template.GameAssets;

import javafx.scene.control.TextArea;

/**
 * mmakes a gameTextArea extending text area with preset looks
 * can make
 */
public class GameTextArea extends TextArea {
        int width= ViewGame.getScreenDimensions();

    /**
     * makes textt with style
     * IS USED FOR NPC DIALOG
     * @param text tht will be displayed
     * @param mood style of font
     */
    public GameTextArea(String text, String mood){
            setText(text);
            //adds style
            getStylesheets().add("colorPalette.css");
            getStyleClass().add("text-area");
            getStyleClass().add(mood+"-label");
            setEditable(false);
            //size
            setMaxSize(width/3,width/48*9);
           setStyle("-fx-font-size: "+ width/20);
        }

    /**
     * IS USED FOR NPC NAME DISPLAY
     * makes default gametext arera with game-label preset
     * @param text the text tht will be displayed
     */
    public GameTextArea(String text){
        setText("\t"+text);
        getStylesheets().add("colorPalette.css");
        getStyleClass().add("text-area");
        getStyleClass().add("game-label");
        setEditable(false);
    }

    /**
     * changes the style of the font
     * @param mood the style/mood of font
     */
        public void changeMood(String mood){
            //uses CSS class with the mood/style
          getStyleClass().add(mood+"-label");
        }

    }

