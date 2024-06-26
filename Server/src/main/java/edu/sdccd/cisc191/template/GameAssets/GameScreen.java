package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.NPCDialog.Speech;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * creatres a game screen with the player layout on the bottom and everythiing else on top
 */
public class GameScreen {
    //the player layouut on the bottom with their stats, pfp, and inventory
    private static GridPane playerLayout;
    //the screen layout
    private static GridPane wholeUi;
    private static ViewGame game = new ViewGame();
    private static Player gamer;
    private static int screenWidth, screenHeight;

    private static Speech speech;
    static PropertyChangeListener isUpdated = evt -> {
        if (!gamer.getInventory().isUptodate()){
            gamer.getInventory().displayInventory();
            setPlayerLayout(gamer,screenWidth,screenHeight);
        }
    };
    private static PropertyChangeSupport listener;

    {
        listener = new PropertyChangeSupport(this);
        listener.addPropertyChangeListener(isUpdated);
    }


    /**
     * sets the player layout with their stats, pfp, and inventory on the bottom
     * @param player the player object
     * @param screenWidth the width of the stage
     * @param screenHeight the height of the stage
     */
    public static void setPlayerLayout(Player player, int screenWidth, int screenHeight){

        gamer=player;
        //playerinfo bottom area
        playerLayout = new GridPane();
        playerLayout.setPrefWidth(screenWidth);
        playerLayout.setPrefHeight(screenHeight);
        playerLayout.setPrefSize(screenWidth,screenWidth*3/48);
        //adds profile pictuure and inventory
        playerLayout.add(player.getPFP(),1,0,2,1);
        playerLayout.add(player.getInventory().displayInventory(),3,0,1,1);
        playerLayout.add(player.getKnowlege().displayKnowlege(),4,0,1,1);
        //adds the textual stats
        playerLayout.add(player.displayProfile(),0,0,1,1);
        playerLayout.setAlignment(Pos.BOTTOM_CENTER);
        playerLayout.setHgap(25);
        //makes thhe background color
        playerLayout.setStyle("-fx-background-color: #eca7b6");

    }

    /**
     * sets the screen with NPC
     * @param player the player
     * @param npc the npc theyre talking to
     * @param screenWidth width  of  the screen
     * @param screenHeight height of the stage
     * @return the layout of tthe screen
     */
    public static GridPane defaultScreen(Player player, NPC npc, int screenWidth, int screenHeight){
        GameScreen.screenWidth =screenWidth;
        GameScreen.screenHeight =screenHeight;
        setPlayerLayout(player,screenWidth,screenHeight);
        //set up the layout of the scene
        wholeUi = new GridPane();
        //add layout in thhe bottom
        wholeUi.add(playerLayout,0,1,3,1);
        //TODO temp end button that ends thhe game
        GameButton endGame = new GameButton("End",screenWidth/3,screenHeight/5,screenWidth/20);
        endGame.setOnAction((ActionEvent theEnd) ->{
            game.endGame();
        });
        wholeUi.add(endGame,2,0,1,1);

        //put the npc picture and dialog
        wholeUi.add(npc.displayProfile(),0,0,1,1);
        speech = new Speech(npc);
        wholeUi.add(speech.getDialogBox().displayText(),1,0,1,1);

        wholeUi.alignmentProperty().set(Pos.BOTTOM_CENTER);

        return wholeUi;

    }
    public static void nextNPC(){
        NPC newNPc = new NPC(true);

        wholeUi.getChildren().remove(speech.getSpeaker().displayProfile());
        wholeUi.getChildren().remove(speech.getDialogBox().displayText());

        speech.changeNPC(newNPc);
        wholeUi.add(newNPc.displayProfile(),0,0,1,1);
        wholeUi.add(speech.getDialogBox().displayText(),1,0,1,1);

    }
    public void inventoryChanged(){

        PropertyChangeListener isUpdated = evt -> {
            if (!gamer.getInventory().isUptodate()){
                gamer.getInventory().displayInventory();
            }
        };
        listener.addPropertyChangeListener(isUpdated);

    }

}
