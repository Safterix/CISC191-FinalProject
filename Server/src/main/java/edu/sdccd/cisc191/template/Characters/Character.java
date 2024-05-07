package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.ItemTypes.Inventory;

import javax.persistence.*;

/**
 * makes a ahrcater with name, money, health, rep, and inventory
 *
// */
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Character
{
//    @Id
    private String name; //name of the character
    private int money; //amount of money they have
    private int health; // amount of hp they have
    private final int MAX_HEALTH;
    private int reputation; // reputation from [-100,100]

//    @OneToOne(fetch = FetchType.EAGER)
    private Inventory storage;



    /**
     * Constructor that sets the character's name, money, and health
     * @param name the character's name
     * @param money the character's money
     * @param health the character's health
     */
    public Character(String name, int money, int health, int rep)
    {
        this.name = name;
        this.money = money;
        this.health = MAX_HEALTH = health; //sets the final field MAX_HEALTH, then sets health
        reputation = rep;
        storage= new Inventory(true);

    }

    public Character() {
        MAX_HEALTH = 100;
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
        //todo probaly have an ingame alert maybe and you cant spend the money u have to do somthign else
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
     * @return name of charcater
     */
    public String getName()
    {
        return name;
    }

    /**
     * ONLY USED FOR NPCS TO REVEAL THEIR NAMES, EQUIV OF SET NAME.
     * player shoudlnt be able to change name me thinky but not sure
     * @param newName
     */
   public void revealName(String newName){
        name= newName;
       //this is for when you ahve a "Mysterious Man" and you reveal who they are i guess
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
     * heals character by healAmount
     */
    public void heal(int healAmount)
    {
        health += healAmount;

    }

    /**
     * take damage, and if it is player the game ends
     * @param damage take damage amount
     */
    public void damage(int damage)
    {
        health -= damage;
        //if the health is 0 and it is the player, then they die
        if (health < 0&&( this.getClass() == Player.class))
        {
           ViewGame lala = new ViewGame();
           lala.endGame(); //end game screen

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
     * @return return inventory
     */
    public Inventory getInventory(){return storage;}



}
