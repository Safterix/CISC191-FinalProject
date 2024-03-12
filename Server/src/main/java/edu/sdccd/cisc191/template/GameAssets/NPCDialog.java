package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.Characters.Player;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import javax.swing.text.View;

public class NPCDialog {
    GameTextArea chatBox;
    TextArea nameBox;
    String speakerName;
    GameImageView emotionSprite;
    StackPane dialog;
    public NPCDialog(NPC speaker, String text, String mood){
        speakerName = speaker.getName().replaceAll("\\s", "");;
        nameBox = new TextArea(speaker.getName());
        nameBox.getStylesheets().add("colorPalette.css");
        nameBox.getStyleClass().add("text-area");
        nameBox.setStyle("-fx-font-size: "+ ViewGame.getScreenDimensions()/40);
        nameBox. setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/30);
        nameBox.editableProperty().set(false);

        emotionSprite = new GameImageView(new Image("image/Sprites/"+speakerName+"_neutral.png"),true);

        chatBox = new GameTextArea(text,mood);

    }
    public void changeDialog(String text, String mood){
        chatBox.setText(text);
        chatBox.changeMood(mood);
        emotionSprite.setImage(new Image("image/Sprites/"+speakerName+"_"+mood+".png"));
    }

    public StackPane displayText(){
        GridPane profile = new GridPane();
        profile.add(emotionSprite,0,0,1,1);
        profile.add(nameBox,1,0,1,1);
        profile.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/5);
        profile.add(chatBox,0,1,1,1);

        dialog= new StackPane(chatBox);
        dialog.getChildren().add(profile);
        StackPane.setAlignment(profile, Pos.TOP_CENTER);

        dialog.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/2);
        return dialog;
    }

}
