package edu.sdccd.cisc191.template.ItemTypes;

/**
 * heal items with enums to pick TODO MAKE OTHER ITEMS HAVE ENUMS TOO
 * has heal the heal amount number
 */
public class Heal extends Goods{
        //options of items
        public HealingItems itemOptions;
        public enum HealingItems {
            APPLE, GINSENG;
        }

        private int heal;
        //picks random item
        public Heal(){
            int pick = (int) (Math.random() * HealingItems.values().length);
            switch(pick){
                case 1:
                    setName("Apple");
                    setDescription("Eat it to restore 30 HP!");
                    heal= 30;
                    setValue(5);
                    break;

                case 2:
                    setName("Ginseng");
                    setDescription("Make stew to cure aliements! 50HP");
                    heal =50;
                    setValue(100);
                    break;


            }
        }
    //makes intentional item
    /**
     * makes item with enum
     * @param item the name of the item from HealingItems enum
     */
    public Heal(HealingItems item){
        itemOptions= item;
        switch(itemOptions){
            case APPLE:
                setName("Apple");
                setDescription("Eat it to restore 30 HP!");
                heal= 30;
                setValue(5);
                break;

            case GINSENG:
                setName("Ginseng");
                setDescription("Make stew to cure aliements! 50HP");
                heal =50;
                setValue(100);
                break;

        }
    }

        public Heal(String name, String  description, int price, int heal){
            super(name,description,price);
            this.heal = heal;
        }
        public int getHeal() {
            return heal;
        }

    }

