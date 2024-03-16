package edu.sdccd.cisc191.template.ItemTypes;

/**
 * heal items with enums to pick TODO MAKE OTHER ITEMS HAVE ENUMS TOO
 * has heal the heal amount number and everything in goods
 */
public class Consumable extends Goods{
        //options of items from china
        public static ConsumableItems[] china = new ConsumableItems[]{ConsumableItems.Apricot,ConsumableItems.Peach, ConsumableItems.Tea,
                                                        ConsumableItems.Rice,ConsumableItems.Plum};
    //options of items from india
    public static ConsumableItems[] india = new ConsumableItems[]{ConsumableItems.Tea,ConsumableItems.Watermelon, ConsumableItems.Eggplant,
            ConsumableItems.Cucumber};
    //options of items from persia
    public static ConsumableItems[] persia = new ConsumableItems[]{ConsumableItems.Dates,ConsumableItems.Pistachio, ConsumableItems.Wine};
//TODO ITEMS FROM ARABIA

    /**
     * enum of all the avialable consumable items
     */
    public enum ConsumableItems {
            Apricot,Peach,Plum,Tea,Wine,Rice,Watermelon,Eggplant,Cucumber,Dates,Pistachio;
        }

        private int heal; // the heal value of the item

    /**
     * constructor that picks random item based on region
     * @param region
     */
    public Consumable(ConsumableItems[] region){
        this(region[(int)(Math.random()*region.length)]);
    }

    /**
     * consturctor taht picks random item regardless of region
     */
    public Consumable(){
        //picks a random number that is no more than the consumable items enum options
        //each umber is assigned an item so picks one based on number
            int pick = (int) (Math.random() * ConsumableItems.values().length);
            switch(pick){
                case 1:
                    setName("Apricot");
                    setDescription("Eat it to restore 10 HP!");
                    heal= 10;
                    setValue(5);
                    break;

                case 2:
                    setName("Peach");
                    setDescription("Tasty Chinese classic! Heal 10HP");
                    heal =10;
                    setValue(5);
                    break;
                case 3:
                    setName("Plum");
                    setDescription("Delicious fruit...Heal 10HP");
                    heal =10;
                    setValue(5);
                    break;
                case 4:
                    setName("Tea");
                    setDescription("SlurpSlurp...Heal 10HP");
                    heal =10;
                    setValue(5);
                    break;
                case 5:
                    setName("Wine");
                    setDescription("Delicious...Heal 10HP");
                    heal =10;
                    setValue(5);
                    break;

            }
        }

    /**
     * makes item with enum, picks specific item
     * @param item the name of the item from HealingItems enum
     */
    public Consumable(ConsumableItems item){
        switch(item){
            case Apricot:
                setName("Apricot");
                setDescription("Eat it to restore 10 HP!");
                heal= 10;
                setValue(5);
                break;

            case Peach:
                setName("Peach");
                setDescription("Tasty Chinese classic! Heal 10HP");
                heal =10;
                setValue(5);
                break;
            case Plum:
                setName("Plum");
                setDescription("Delicious fruit...Heal 10HP");
                heal =10;
                setValue(5);
                break;
            case Tea:
                setName("Tea");
                setDescription("SlurpSlurp...Heal 10HP\nWorth "+getValue()+" coins");
                heal =10;
                setValue(5);
                break;
            case Wine:
                setName("Wine");
                setDescription("Delicious...Heal 10HP");
                heal =10;
                setValue(5);
                break;
            case Rice:
                setName("Rice");
                setDescription("Fluffy rice! Heal 50HP");
                heal =50;
                setValue(1);
                break;

        }
    }

    /**
     * get the heal
     * @return heal amount
     */
        public int getHeal() {
            return heal;
        }

    }

