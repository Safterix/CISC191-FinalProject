package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.GameTooltip;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Player extends Character {


    private int score;
    private String goal;
    public Player(String name, int money, int health, short rep){
        super(name,money,health,rep);
        score  = 0;
        goal= "None";
    }

    public void addScore(int score){
        this.score += score;

    }
    public void setGoal(String goal){
        this.goal = goal;
        GameTooltip hoverGoal = new GameTooltip("I want to "+getGoal().toLowerCase()+"!");
        GameTooltip.install(getPFP(),hoverGoal);
    }
    public String getGoal(){
        return goal;
    }
    public int getScore(){
        return score;
    }

    /**
     * TODO but changes expression of player
     * @param expression the expression tec hacrater is doing
     */
    public void changeExpression(String expression){
        getPFP().setImage(new Image("image/Sprites/" +expression));
        // set it to diff picture
    }


    /**
     * formats the name and stats of the player
     * @return VBox with labels of name, health, money and rep
     */
    public VBox displayProfile(){
        //get all numeric stats and add to a VBOx that goes into (0,2) of the gridpane
        int size = ViewGame.getScreenDimensions()/30;
        GameLabel health = new GameLabel("Health: "+ getHealth() +"/"+ getMAX_HEALTH(),size,"red");
        GameLabel money = new GameLabel("Money: "+ getMoney(),size, "green");
        GameLabel reputation = new GameLabel("Rep: "+ getReputation(),size);

        GameLabel playerName = new GameLabel(getName(),size*2);
        //adds all of them to a VBox stack
        VBox stats = new VBox(playerName, health,money,reputation);


        return stats;
}

}
