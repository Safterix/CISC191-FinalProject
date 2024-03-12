package edu.sdccd.cisc191.template.ItemTypes;

/**
 * goods item TODO WIP WIP
 * has value to be sold
 *
 */
public class Goods extends Item{

    public static CommercialGoods[] china = new CommercialGoods[]{CommercialGoods.Silk,CommercialGoods.Porcelain,CommercialGoods.Gunpowder};
    public static CommercialGoods[] india = new CommercialGoods[]{CommercialGoods.Fabric,CommercialGoods.Spices,CommercialGoods.Dye,
                    CommercialGoods.Ivory};
    public static CommercialGoods[] persia = new CommercialGoods[]{CommercialGoods.Gold,CommercialGoods.Silver,CommercialGoods.Iron
                    ,CommercialGoods.Copper,CommercialGoods.Dye,CommercialGoods.Limestone};
    public static CommercialGoods[] arabia = new CommercialGoods[]{CommercialGoods.Frankincense,CommercialGoods.Incense
    ,CommercialGoods.Pearls,CommercialGoods.Copper};

    public enum CommercialGoods {
        Silk,Porcelain,Gunpowder,Fabric,Spices,Dye,Ivory,Gold,Silver,Iron,Copper,Limestone,Frankincense,Incense,Pearls;
    }
    private int value;

    public Goods(CommercialGoods[] region){
        this(region[(int)(Math.random()*region.length)]);
    }
    public Goods(CommercialGoods item){
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

    public Goods(){
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

    public Goods(String name, String  description, int price){
        super(name,description);
        value = price;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
