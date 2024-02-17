package edu.sdccd.cisc191.template;

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


    public void hurt(int damage)
    {
        health -= damage;
        //TODO check for dying
    }

    public void heal (int healing)
    {
        health += healing;
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
}
