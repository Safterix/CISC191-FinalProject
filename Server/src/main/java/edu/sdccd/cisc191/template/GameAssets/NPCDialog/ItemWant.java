package edu.sdccd.cisc191.template.GameAssets.NPCDialog;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.ItemTypes.Item;

import java.util.Random;

import static edu.sdccd.cisc191.template.GameAssets.NPCDialog.Speech.setDialog;

public class ItemWant {
    //how much they want item
        private int want;
        private final static int choices = 3;
        private Item focusItem;


    public ItemWant(Item item){
        want=new Random().nextInt(choices+1);
        focusItem=item;

    }
    public void getDialogText(){
        switch(want){
            case 1:{
                setDialog("I want that "+focusItem.getName() +" right now...", NPC.Personality.happy);
                break;
            }
            case 2:{
                setDialog( "That "+focusItem.getName() +" is fine", NPC.Personality.neutral);
                break;
            }
            case 3:{
                setDialog("I HATE THAT "+focusItem.getName().toUpperCase() +" SO MUCH!!", NPC.Personality.angry);

                break;
            }
        }


}

    public double getMultiplier(){
        switch(want){
            case 1:{
                return 2;
            }
            case 2:{
                return 1;
            }
            case 3:{
                return 0.5;
            }
    }
    return 0;
}


}

