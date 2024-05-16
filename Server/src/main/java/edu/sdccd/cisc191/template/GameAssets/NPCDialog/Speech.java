package edu.sdccd.cisc191.template.GameAssets.NPCDialog;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.ItemTypes.Item;

import java.util.Random;

/**
 * determines what the charcaters say based on their mood, their want for an item
 * and their personailty
 */
public class Speech {
    private NPC speaker; //npc that is speaking
    private NPC.Personality speakerPersonality; //their personailty to determine what kind of dialog
    private static DialogBox display; //the dialog box
    private static NPC.Personality mood; //if your actions change the mood, but will not affect generic personailty
    //based dialog

    /**
     * creates a dialog box and sets up info for future dialog
     * @param speaker the character that is speaking
     */
    public Speech(NPC speaker){
        this.speaker=speaker;

        //its only happy rn so
        speakerPersonality =speaker.getPersonality(); //get their personailty to determine what intro


        mood = NPC.Personality.happy; //default mood is happy
    //if the charcater is a nervous character they will have the Mysterious settings where their name is unknown
        if(speakerPersonality== NPC.Personality.nervous){
         display = new DialogBox(speaker, introduction(), speakerPersonality.toString(), true);}
        else{display = new DialogBox(speaker, introduction(), speakerPersonality.toString(), false);}




    }
    public void changeNPC(NPC newNPC){
        speaker = newNPC;
        speakerPersonality =newNPC.getPersonality();
        if(speakerPersonality== NPC.Personality.nervous){
            display = new DialogBox(speaker, introduction(), speakerPersonality.toString(), true);}
        else{display = new DialogBox(speaker, introduction(), speakerPersonality.toString(), false);}
        //refreshes all the itemwant stats
        for(Item item: ViewGame.getPlayer().getInventory().getAllItems()){
            item.setWant(new ItemWant(item));
        }

    }
    /**
     * characters introducing themslves
     * @return their intro duction
     */
    private String introduction() {
        switch(speakerPersonality){
            case angry:{
               return "My name?!! It's " + speaker.getName()+"...";
            }
            case happy:{
                return "Hai hai! I'm " + speaker.getName()+"!!";
            }
            case silly:{
                return speaker.getName()+"'s the name!";
            }
            case excited:{
                return "HI HELLO!! MY NAME IS " + speaker.getName()+"!!!";
            }
            case nervous:{
                return "...";
            }
            case neutral:{
                return "Hello. My name is " + speaker.getName()+"...";
            }
            case indifferent:{
                return "Hi. I'm " + speaker.getName()+".";
            }
        }
        return "...";

    }

    /**
     * if conversation sparks about a certain item
     * @param item the item of the topic
     */

    public static void talkAbout(Item item){
    if(!item.isNothing()){
        item.getDialog();}
    else{setDialog("...", NPC.Personality.neutral);}
    }


    /**
     * change the dialog input the text and current mood
     */
    public static void setDialog(String dialogText){
        display.changeDialog(dialogText,mood.toString());
    }
    /**
     * change the dialog input the text and current mood
     */
    public static void setDialog(String inDialog, NPC.Personality inMood){
        display.changeDialog(inDialog,inMood.toString());
    }

    /**
     * @return the dialog box to display
     */
    public DialogBox getDialogBox(){
        return display;
    }
    public NPC getSpeaker() {
        return speaker;
    }

    public void setSpeaker(NPC speaker) {
        this.speaker = speaker;
    }
}
