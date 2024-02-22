package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.DefaultText;
import javafx.scene.canvas.Canvas;
import  javafx.scene.canvas.CanvasBuilder;
import  javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Player extends Character {
    Canvas profilee;
    GraphicsContext pfp; //?????????????

    int score;
    public Player(String name, int money, int health, int rep){
        super(name,money,health,rep);
        score  = 0;

    }

    public void addScore(int score){
        this.score += score;

    }

    public int getScore(){
        return score;
    }


    public GridPane getProfile(int screenWidth, int screenHeight){
        //get all numeric stats and add to a VBOx that goes into (0,2) of the gridpane
        DefaultText health = new DefaultText("Health: "+ getHealth(),20,"#AA0C0C");
        DefaultText money = new DefaultText("Money: "+ getMoney(),20, "#9FB425");
        DefaultText reputation = new DefaultText("Rep: "+ getReputation(),20);
        VBox stats = new VBox(health,money,reputation);

        GridPane profile = new GridPane();
        profile.add(stats, 0,2,2,1);
        //todo add profile pic of player in (0,1)

        //adds the name to (0,0) of gridpane
        DefaultText playerName = new DefaultText(getName(),40);
        profile.add(playerName,0,0);

        return profile;
}

}
