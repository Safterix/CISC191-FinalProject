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
    private int reputation; // reputation TODO implement reputation

    private Item[][] inventory; //multidimensional array inventory TODO decide on how inventory size works

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
        inventory = new Item[3][3];
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
    /**
     * @return max health
     */
    public int getReputation()
    {
        return reputation;
    }

    public Item[][] getInventory(){
        return inventory;}

    public GridPane displayInventory(int screenWidth, int screenHeight){

    GridPane inventoryShow =new GridPane();
    //TODO make it so all the items int he inventory gets its own image/label/thing for a gridpane
    return inventoryShow;
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
