package edu.sdccd.cisc191.template.GameAssets.NPCDialog;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.GameTextArea;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import static edu.sdccd.cisc191.template.GameAssets.GameScreen.nextNPC;

/**
 * npc dialog class that makes the dialog box for NPCS
 * shows the name, little profile picture with their emotion, and their dialog in a stackpane
 * USED FOR WHEN NPCS ARE SPEAKING
 */
public class DialogBox {

    GameTextArea chatBox;//dialog box
    GameTextArea nameBox;  //the NPC name display
    String speakerName; //name of npc
    GameImageView emotionSprite; // profile picture with NPC's expression

    HBox options;
    GameButton option1,option2,option3;

    /**
     * makes the NPCdialog box with a profile picture, name, and dialog box
     * @param intro character intro
     * @param speaker the NPC that is speaking, will have to get their name
     * @param mood the mood of the conversation, used for the font style and also expression face
     * @param mysterious  if they are mysterious or not
     */
    public DialogBox(NPC speaker, String intro, String mood, boolean mysterious){
        //adds the speakers name to the name box and sets its size
        if(!mysterious){
        nameBox = new GameTextArea(speaker.getName());}
        else{
            nameBox = new GameTextArea("Unknown");
        }
        nameBox.setStyle("-fx-font-size: "+ ViewGame.getScreenDimensions()/45);
        nameBox. setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/30);
        nameBox.editableProperty().set(false); // so that users cannot type in it

        //gets the name of the speaker to search for files
        //it is the name of the speaker but without spaces
        speakerName = speaker.getName().replaceAll("\\s", "");;

        //sets the emotion profile picture for the NPC with their spaceless name and the mood
        emotionSprite = new GameImageView(speakerName, mood);

        //makes the chatbox, a gametextarea with the dialog and mood
        //the mood determines the font style
        chatBox = new GameTextArea(intro,mood);
        setOptions();

    }


    public void setOptions(){

        option1=new GameButton("Hi",ViewGame.getScreenDimensions()/9,ViewGame.getScreenDimensions()/15,ViewGame.getScreenDimensions()/45);
        option1.setOnAction(event ->{
            changeDialog("Hi!", "happy");
        });
        option2=new GameButton("...",ViewGame.getScreenDimensions()/9,ViewGame.getScreenDimensions()/15,ViewGame.getScreenDimensions()/45);
        option2.setOnAction(event ->{
            changeDialog("...", "neutral");
        });
        option3=new GameButton("Bye!",ViewGame.getScreenDimensions()/9,ViewGame.getScreenDimensions()/15,ViewGame.getScreenDimensions()/45);

        option3.setOnAction(event ->{
        nextNPC();});
        options= new HBox(option1,option2,option3);
        options.setAlignment(Pos.CENTER);
    }
    /**
     * changes the dialog to something else, changes the mood as well
     * @param text the dialog of the NPC
     * @param mood the mood of the NPC
     */
    public void changeDialog(String text, String mood){
        //changes text
        chatBox.setText(text);
        //changes mood
        chatBox.changeMood(mood);
        //changes the emotion sprite/ pfp with the mood
        emotionSprite.setImage(new Image("image/Sprites/"+speakerName+"_"+mood+".png"));
    }

    /**
     * displays the dialog, formats all of it in a stack pane
     * with name and icon pfp on top and dialog box on the bottom
     * @return the borderpane field with the NPC profile and dialog
     */
    public BorderPane displayText(){
        //makes new stack pane and alligns everything bottom left
        //it holds the name and icon
        StackPane profileReal = new StackPane(nameBox,emotionSprite);
        profileReal.setAlignment(Pos.BOTTOM_LEFT);
        //set size of the stackpane
        profileReal.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()*108/16);


        BorderPane real = new BorderPane(chatBox);
        real.setTop(profileReal);
        real.setBottom(options);
        real.setPadding(Insets.EMPTY);
        real.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions());
        return real;
    }

}
