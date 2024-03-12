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
import java.util.Stack;

public class NPCDialog {
    GameTextArea chatBox;
    GameTextArea nameBox;
    String speakerName;
    GameImageView emotionSprite;
    StackPane dialog;
    public NPCDialog(NPC speaker, String text, String mood){
        speakerName = speaker.getName().replaceAll("\\s", "");;
        nameBox = new GameTextArea(speaker.getName());
        nameBox.setStyle("-fx-font-size: "+ ViewGame.getScreenDimensions()/45);
        nameBox. setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/30);
        nameBox.editableProperty().set(false);

        emotionSprite = new GameImageView(new Image("image/Sprites/"+speakerName+"_"+mood+".png"),true);
        GameTooltip emotion = new GameTooltip(mood);
        GameTooltip.install(emotionSprite,emotion);

        chatBox = new GameTextArea(text,mood);

    }
    public void changeDialog(String text, String mood){
        chatBox.setText(text);
        chatBox.changeMood(mood);
        emotionSprite.setImage(new Image("image/Sprites/"+speakerName+"_"+mood+".png"));
    }

    public StackPane displayText(){

        StackPane profileReal = new StackPane(nameBox,emotionSprite);
        profileReal.setAlignment(Pos.BOTTOM_LEFT);

        profileReal.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()*108/16);
        GridPane profile = new GridPane();
        profile.add(profileReal,0,0,1,1);
        profile.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/5);
        profile.add(chatBox,0,1,1,1);

        dialog= new StackPane(chatBox);
        dialog.getChildren().add(profile);
        StackPane.setAlignment(profile, Pos.TOP_CENTER);

        dialog.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/2);
        return dialog;
    }

}
