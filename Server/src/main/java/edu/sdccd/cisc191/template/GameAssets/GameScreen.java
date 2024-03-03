package edu.sdccd.cisc191.template.GameAssets;

import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.Characters.Player;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameScreen {
    //todo the basic/ main ui of the game
    public static GridPane defaultScreen(Player player,int screenWidth, int screenHeight){
        //playerinfo bottom area
        GridPane wholeUi = new GridPane();
        wholeUi.setPrefWidth(screenWidth);
        wholeUi.setPrefHeight(screenHeight);
        wholeUi.setGridLinesVisible(true);
        //add charcater
        wholeUi.add(player.displayProfile(),0,1,1,1);
        wholeUi.add(player.getPFP(),1,1,1,1);

        wholeUi.add(player.getInventory().displayInventory(screenWidth/15),2,1,1,1);
        wholeUi.setAlignment(Pos.BOTTOM_CENTER);
        //todo map backhtund, npc/event, options, dialog
        StackPane gameEvents;

        return wholeUi;

    }
}
