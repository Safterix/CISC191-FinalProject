package edu.sdccd.cisc191.template.ItemTypes;

/**
 * heal items with enums to pick TODO MAKE OTHER ITEMS HAVE ENUMS TOO
 * has heal the heal amount number
 */
public class Consumable extends Goods{
        //options of items
        public ConsumableItems itemOptions;
        public enum ConsumableItems {
            Apricot,Peach,Plum,Tea,Wine,Rice,Watermelon,Eggplant,Cucumber,Dates,Pistachio;
        }

        private int heal;
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
        itemOptions= item;
        switch(itemOptions){
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
                setDescription("SlurpSlurp...Heal 10HP");
                heal =10;
                setValue(5);
                break;
            case Wine:
                setName("Wine");
                setDescription("Delicious...Heal 10HP");
                heal =10;
                setValue(5);
                break;

        }
    }

        public Consumable(String name, String  description, int price, int heal){
            super(name,description,price);
            this.heal = heal;
        }
        public int getHeal() {
            return heal;
        }

    }

