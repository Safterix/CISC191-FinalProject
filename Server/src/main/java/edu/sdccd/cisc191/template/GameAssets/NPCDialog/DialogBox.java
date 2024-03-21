package edu.sdccd.cisc191.template.GameAssets.NPCDialog;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.GameTextArea;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

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
    StackPane dialog; // stackpane that has all of the above


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
     * @return the stackpane field with the NPC profile and dialog
     */
    public StackPane displayText(){
        //makes new stack pane and alligns everything bottom left
        //it holds the name and icon
        StackPane profileReal = new StackPane(nameBox,emotionSprite);
        profileReal.setAlignment(Pos.BOTTOM_LEFT);
        //set size of the stackpane
        profileReal.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()*108/16);


        //make a grid pane which will hold the profile (name and icon) on top
        //and the dialog on the bottom
        GridPane profile = new GridPane();
        profile.add(profileReal,0,0,1,1);
        profile.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/5);

        //add that chatbox to the dialog stackpane field
        dialog= new StackPane(chatBox);
        dialog.getChildren().add(profile);
        StackPane.setAlignment(profile, Pos.TOP_CENTER);

        //honestly idk how i got this to work or why it works coz there is a random gridpane but without it
        //it doesnt align so......

        dialog.setMaxSize(ViewGame.getScreenDimensions()/3,ViewGame.getScreenDimensions()/2);
        return dialog;
    }

}
