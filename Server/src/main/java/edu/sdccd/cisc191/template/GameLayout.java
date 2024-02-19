package edu.sdccd.cisc191.template;

import javafx.scene.layout.*;

/**
 * creates a scene with Choices, Player Stats, and other graphics?
 */
public class GameLayout extends GridPane {
    GameLayout gameLayout;

        public GameLayout(Character player){

            GridPane profile = player.getProfile();

            VBox story;
            //Todo get choices from gameEvents and dialog and put in (1,1)

            GridPane inventory;
            //todo get inventory and display in (2,1)

            //add to the game layout
            gameLayout.add(profile,0,1);



            //TODO consturctor that accpets a layout Character player, Character npc/other chacrater, Location, EVent

        }
        public GameLayout getLayout(){
            return gameLayout;
        }
}
