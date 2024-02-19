package edu.sdccd.cisc191.template;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Character
{
    private String name; //name of the character
    private int money; //amount of money they have
    private int health; // amount of hp they have
    private final int MAX_HEALTH;
    int reputation; // reputation TODO implement reputation
    Item[][] inventory; //multidimensional array inventory TODO decide on how inventory size works

    /**
     * Constructor that sets the character's name, money, and health
     * @param name the character's name
     * @param money the character's money
     * @param health the character's health
     */
    public Character(String name, int money, int health)
    {
        this.name = name;
        this.money = money;
        this.health = MAX_HEALTH = health; //sets the final field MAX_HEALTH, then sets health
        reputation = 0;
    }

    /**
     * @return money
     */
    public int getMoney()
    {
        return money;
    }

    /**
     * Removes from character's money. Throws an exception if this is used to make money go negative
     * @param usedMoney Money to spend
     */
    public void spendMoney(int usedMoney)
    {
        money -= usedMoney;
        if (money < 0)
        {
            throw new IllegalArgumentException(name + " spent more money than they had!");
        }
        //This way, if spendMoney is ever used to go below zero, we will know
        //can be removed if we change how this works
    }

    /**
     * Adds to character's money
     * @param gainedMoney amount of money to gain
     */
    public void gainMoney(int gainedMoney)
    {
        money += gainedMoney;
    }

    /**
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return health
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * @return max health
     */
    public int getMAX_HEALTH()
    {
        return MAX_HEALTH;
    }

    public GridPane getProfile(){
    //get all numeric stats and add to a VBOx that goes into (0,2) of the gridpane
        DefaultText stat = new DefaultText(Integer.toString(health),20);
        VBox stats = new VBox(stat);
        stats.getChildren().add(stat);
        stat = new DefaultText(Integer.toString(money),20);
        stats.getChildren().add(stat);
        stat = new DefaultText(Integer.toString(reputation),20);
        stats.getChildren().add(stat);

        GridPane profile = new GridPane();
        profile.add(stats, 0,2,2,1);
    //todo add profile pic of player in (0,1)

        //adds the name to (0,0) of gridpane
        stat = new DefaultText(name,40);
        profile.add(stat,0,0);

        //todo add inventory button to (1,0)
        return profile;

    }
}
