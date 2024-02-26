package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.Characters.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameScreen {
    //todo the basic/ main ui of the game
    public static GridPane defaultScreen(Player player,int itemSize){
        //playerinfo bottom area
        GridPane wholeUi = new GridPane();
        //add charcater
        wholeUi.add(player.displayProfile(),1,1,1,1);
        wholeUi.add(player.getInventory().displayInventory(itemSize),2,1,1,1);
        //todo add inventor in (2,1)
        //todo map backhtund, npc/event, options, dialog
        StackPane gameEvents;

        return wholeUi;

    }
}
