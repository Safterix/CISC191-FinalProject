package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameAssets.GameImageView;
import edu.sdccd.cisc191.template.GameAssets.GameLabel;
import edu.sdccd.cisc191.template.GameAssets.GameTooltip;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import javax.persistence.*;

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
    @Transient
    private GameLabel healthLabel;
    @Transient
    private GameLabel moneyLabel;
    @Transient
    private GameLabel reputationLabel;
    @Transient
    private GameLabel scoreLabel;

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

        int size = ViewGame.getScreenDimensions()/30;
        //initialze labels
        healthLabel = new GameLabel("Health: "+ getHealth() +"/"+ getMAX_HEALTH(),size,"red");
        moneyLabel = new GameLabel("Money: "+ getMoney(),size, "green");
        reputationLabel = new GameLabel("Rep: "+ getReputation(),size/2);
        scoreLabel = new GameLabel("Score: "+ getScore(),size/2);
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
    public synchronized void addScore(int add){
        score+=add;
        scoreLabel.setText("Score: "+ getScore());
    }
    /**
     *removes score to player
     */
    public void removeScore(int remove){
        score-=remove;
        scoreLabel.setText("Score: "+ getScore());
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
        healthLabel.setText("Health: "+ getHealth() +"/"+ getMAX_HEALTH());
        moneyLabel.setText("Money: "+ getMoney());
         reputationLabel.setText("Rep: "+ getReputation());
        scoreLabel.setText("Score: "+ getScore());

        GameLabel playerName = new GameLabel(getName(),size*2);
        //adds all of them to a VBox stack
        VBox stats = new VBox(playerName, healthLabel,moneyLabel,reputationLabel, scoreLabel);


        return stats;
}
    /**
     * heals character by healAmount
     */
    public void heal(int healAmount)
    {
        setHealth(getHealth()+healAmount);
        healthLabel.setText("Health: "+ getHealth() +"/"+ getMAX_HEALTH());

    }
    @Override
    public void gainMoney(int money){
        setMoney(getMoney()+money);
        moneyLabel.setText("Money: "+ getMoney());
    }
    @Override
    public void spendMoney(int money){
        setMoney(getMoney()-money);
        moneyLabel.setText("Money: "+ getMoney());
    }
    @Override
    public void damage(int damageAmount){
        setHealth(getHealth()-damageAmount);
        healthLabel.setText("Health: "+ getHealth() +"/"+ getMAX_HEALTH());
        //if the health is 0 and it is the player, then they die

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
