package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.Characters.Player;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScreen {
    private Player mc;
    private static GridPane playerLayout;

    public static void setPlayerLayout(Player player, int screenWidth, int screenHeight){

        //playerinfo bottom area
        playerLayout = new GridPane();
        playerLayout.setPrefWidth(screenWidth);
        playerLayout.setPrefHeight(screenHeight);

        playerLayout.add(player.getPFP(),1,0,2,1);
        playerLayout.add(player.getInventory().displayInventory(),3,0,1,1);

        playerLayout.add(player.displayProfile(),0,0,1,1);
        playerLayout.setAlignment(Pos.BOTTOM_CENTER);

        playerLayout.setStyle("-fx-background-color: #eca7b6");
        playerLayout.setPrefSize(screenWidth,screenWidth*3/48);

    }
    public static GridPane defaultScreen(Player player, NPC npc, int screenWidth, int screenHeight){
        if(playerLayout ==null){
        setPlayerLayout(player,screenWidth,screenHeight);}

        GridPane wholeUi = new GridPane();
        wholeUi.add(playerLayout,0,1,3,1);
        GameButton endGame = new GameButton("End",screenWidth/3,screenHeight/5,screenWidth/20);
        endGame.setOnAction((ActionEvent theEnd) ->{
            ViewGame.endGame();
        });


        wholeUi.add(npc.displayProfile(),0,0,1,1);
        wholeUi.add(new NPCDialog(npc,"ouioui","game").displayText(),1,0,1,1);

        wholeUi.add(endGame,2,0,1,1);
        wholeUi.alignmentProperty().set(Pos.BOTTOM_CENTER);


        return wholeUi;

    }

}
