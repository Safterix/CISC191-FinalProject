package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.ItemTypes.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character
{
    private String name; //name of the character
    private int money; //amount of money they have
    private int health; // amount of hp they have
    private final int MAX_HEALTH;
    private short reputation; // reputation from [-100,100]
    private Inventory storage; //TODO decide on how inventory size works

    private ImageView profileImage =new ImageView(new Image("image/creachae.png"));

    /**
     * Constructor that sets the character's name, money, and health
     * @param name the character's name
     * @param money the character's money
     * @param health the character's health
     */
    public Character(String name, int money, int health, short rep)
    {
        this.name = name;
        this.money = money;
        this.health = MAX_HEALTH = health; //sets the final field MAX_HEALTH, then sets health
        reputation = rep;
        storage= new Inventory();
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
     * heals cahracter by healAmount
     */
    public void heal(int healAmount)
    {
        health += healAmount;

    }

    /**
     * @param damage take damge amount
     */
    public void damage(int damage)
    {
        health -= damage;
        if (health < 0)
        {
            //TODO porbably ViewGame.Lose() havent been made yet but YOU DIE!!!!!!!!!!!
        }
    }



    /**
     * @return reputation
     * NPCS have constant reputation while Player has fliud reputation me thinky
     */
    public int getReputation()
    {
        return reputation;
    }
    /**
     * @return return storage
     */
    public Inventory getInventory(){return storage;}

    public ImageView getPFP(){return profileImage;}


}
