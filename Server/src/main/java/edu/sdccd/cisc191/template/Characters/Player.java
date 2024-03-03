package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Player extends Character {


    int score;
    public Player(String name, int money, int health, short rep){
        super(name,money,health,rep);
        score  = 0;

    }

    public void addScore(int score){
        this.score += score;

    }

    public int getScore(){
        return score;
    }

    public void changeExpression(int type){
        getPFP().setImage(new Image("image/charcaterSprites/creachae.png")); // set it to diff picture
    }


    public GridPane displayProfile(){
        //get all numeric stats and add to a VBOx that goes into (0,2) of the gridpane
        int size = ViewGame.getScreenDimensions()/30;
        GameLabel health = new GameLabel("Health: "+ getHealth() +"/"+ getMAX_HEALTH(),size,"red");
        GameLabel money = new GameLabel("Money: "+ getMoney(),size, "green");
        GameLabel reputation = new GameLabel("Rep: "+ getReputation(),size);
        //TODO IDK WHY the font is smalelr....
        VBox stats = new VBox(health,money,reputation);

        GridPane profile = new GridPane();
        profile.add(stats, 0,2,2,1);
        //adds the name to (0,0) of gridpane
        GameLabel playerName = new GameLabel(getName(),size*2);
        profile.add(playerName,0,0,1,2);

        return profile;
}

}
