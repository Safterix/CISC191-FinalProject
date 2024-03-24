package edu.sdccd.cisc191.template.ItemTypes;

/**
 * goods item TODO WIP WIP
 * has value and everythign Item
 *
 */
public class Goods extends Item{

    //all the commicerial goods in china
    public static CommercialGoods[] china = new CommercialGoods[]{CommercialGoods.Silk,CommercialGoods.Porcelain,CommercialGoods.Gunpowder};
    //all the commicerial goods in india
    public static CommercialGoods[] india = new CommercialGoods[]{CommercialGoods.Fabric,CommercialGoods.Spices,CommercialGoods.Dye,
                    CommercialGoods.Ivory};
    //all the commicerial goods in persia
    public static CommercialGoods[] persia = new CommercialGoods[]{CommercialGoods.Gold,CommercialGoods.Silver,CommercialGoods.Iron
                    ,CommercialGoods.Copper,CommercialGoods.Dye,CommercialGoods.Limestone};
    //all the commicerial goods in arabia
    public static CommercialGoods[] arabia = new CommercialGoods[]{CommercialGoods.Frankincense,CommercialGoods.Incense
    ,CommercialGoods.Pearls,CommercialGoods.Copper};

    @Override
    public int compareTo(Item item) {

        if(item.getClass()==Goods.class||item.getClass()==Consumable.class){

            if(this.getValue()>((Goods) item).getValue()){
                    return 1;}
            else if (this.getValue()==((Goods) item).getValue()) {
                return 0;
            }
        }

        return -1;
    }

    /**
     * commerical goods enum with all the commerial goods options
     */
    public enum CommercialGoods {
        Silk,Porcelain,Gunpowder,Fabric,Spices,Dye,Ivory,Gold,Silver,Iron,Copper,Limestone,Frankincense,Incense,Pearls
    }
    private int value; // price of the item

    /**
     * picks random commerical good from a region, ex. put china pics a random chinese item
     * @param region
     */
    public Goods(CommercialGoods[] region){
        this(region[(int)(Math.random()*region.length)]);
    }

    /**
     * goods constructor that accepts an item from the comcerialgoods enum
     * makes item with name, and edscrption
     * sets the value of the item
     * @param item
     */
    public Goods(CommercialGoods item){
        //goes thru all the enums and checks if it is the right item
        switch(item){
            case Silk:
                setName("Silk");
                setDescription("Smooth,shiny,and luxurious...\nWorth "+getValue()+" coins");
                setValue(100);
                break;
            case Porcelain:
                setName("Porcelain");
                setDescription("Fragile!!!\nWorth "+getValue()+" coins");
                setValue(100);
                break;
            case Gunpowder:
                setName("Gunpowder");
                setDescription("BOOM! BOOM!");
                setValue(50);
                break;
            case Fabric:
                setName("Fabric");
                setDescription("All your sewing needs");
                setValue(10);
                break;
            case Spices:
                setName("Spices");
                setDescription("Flavorful");
                setValue(10);
                break;
            case Dye:
                setName("Dye");
                setDescription("Dye your silk!");
                setValue(50);
                break;

        }
    }

    /**
     * random constructor that pics a random item rfom all the consumable items
     */
    public Goods(){
        //picks a random number and that number will determine what the item is
        int pick = (int) (Math.random() * Consumable.ConsumableItems.values().length);
        switch(pick){
            case 1:
            setName("Silk");
            setDescription("Smooth,shiny,and luxurious...");
            setValue(100);
            break;
            case 2:
                setName("Porcelain");
                setDescription("Fragile!!!");
                setValue(100);
                break;
            case 3:
                setName("Gunpowder");
                setDescription("BOOM! BOOM!");
                setValue(50);
                break;
            case 4:
                setName("Fabric");
                setDescription("All your sewing needs");
                setValue(10);
                break;
            case 5:
                setName("Spices");
                setDescription("Flavorful");
                setValue(10);
                break;
            case 6:
                setName("Dye");
                setDescription("Dye your silk!");
                setValue(50);
                break;
        }}

    /**
     * gets the monetary value of the item
     * @return the price of item
     */
    public int getValue() {
        return value;
    }

    /**
     * sets the value price
     * @param value the price of item
     */
    public void setValue(int value) {
        this.value = value;
    }
}
