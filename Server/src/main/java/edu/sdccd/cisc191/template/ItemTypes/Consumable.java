package edu.sdccd.cisc191.template.ItemTypes;

/**
 * heal items with enums to pick TODO MAKE OTHER ITEMS HAVE ENUMS TOO
 * has heal the heal amount number
 */
public class Consumable extends Goods{
        //options of items
        public static ConsumableItems[] china = new ConsumableItems[]{ConsumableItems.Apricot,ConsumableItems.Peach, ConsumableItems.Tea,
                                                        ConsumableItems.Rice,ConsumableItems.Plum};
    public static ConsumableItems[] india = new ConsumableItems[]{ConsumableItems.Tea,ConsumableItems.Watermelon, ConsumableItems.Eggplant,
            ConsumableItems.Cucumber};
    public static ConsumableItems[] persia = new ConsumableItems[]{ConsumableItems.Dates,ConsumableItems.Pistachio, ConsumableItems.Wine};


    public enum ConsumableItems {
            Apricot,Peach,Plum,Tea,Wine,Rice,Watermelon,Eggplant,Cucumber,Dates,Pistachio;
        }

        private int heal;
    public Consumable(ConsumableItems[] region){
        this(region[(int)(Math.random()*region.length)]);
    }

        //picks random item
        public Consumable(){
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
    //makes intentional item
    /**
     * makes item with enum
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

        public int getHeal() {
            return heal;
        }

    }

