package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.GameTooltip;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.ItemTypes.Goods;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import javax.persistence.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * makes PLAYER YAYER!!!
 * has score, goal, and pfp
 */
@Entity
public class Player extends Character {
    @GeneratedValue
    @Column(unique=true)
        private Integer id;

    private Integer score;
    private String goal;
    @Transient
    private GameImageView profileImage;
    @Transient
    private KnowlegeBar knowlege;


    public Player(){
       this("None");
    }
    /**
     * make player, they have a name
     * @param name of player that is set
     */
    public Player(String name){
        super(name,0,100,0);
        score  = 0;
        goal= "None";
        knowlege = new KnowlegeBar();
        profileImage=new GameImageView(new Image("image/Sprites/Player.png"));
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * sets the goal of the player, when you hover over player they will say their goal!!!
     * @param goal
     */
    public void setGoal(String goal){
        this.goal = goal;
        //tool tip that says the goal
        GameTooltip hoverGoal = new GameTooltip("I want to "+getGoal().toLowerCase()+"!");
        GameTooltip.install(getPFP(),hoverGoal);
    }

    /**
     *
     * @return player's goal
     */
    public String getGoal(){
        return goal;
    }
    /**
     *
     * @return player's score
     */
    public Integer getScore(){
        return score;
    }

    /**
     *adds score to player
     */
    public void addScore(int add){
        score+=add;
    }

    /**
     * TODO but changes expression of player
     * @param mood the expression tec hacrater is doing
     */
    public void changeExpression(String mood){
        getPFP().setImage(new Image("image/Sprites/Player_" +mood +".png"));
        // set it to diff picture TODO
    }


    /**
     * @return pfp
     */
    public GameImageView getPFP() {
        return profileImage;
    }


    public KnowlegeBar getKnowlege(){return knowlege;}

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

    /**
     * comapres the scores of players
     * @param player2
     * @return if greate o lesser
     */
    public int compareTo(Player player2){
        if(player2.getScore()>getScore()){
            return 1;
        } else if (player2.getScore()<getScore()) {
            return -1;

        }
        return 0;
}


@Override
    public String toString(){
        return getName() + ": " +getScore();
}
}
