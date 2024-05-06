package edu.sdccd.cisc191.template.GameAssets.NPCDialog;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.ItemTypes.Item;

/**
 * determines what the charcaters say based on their mood, their want for an item
 * and their personailty
 */
public class Speech {
    NPC speaker; //npc that is speaking
    final NPC.Personality speakerPersonality; //their personailty to determine what kind of dialog
    DialogBox display; //the dialog box
    NPC.Personality mood; //if your actions change the mood, but will not affect generic personailty
    //based dialog
    String dialogText; //dialog text
    int want; // 0-2 scale of how much they want it, could be how much theyre willing to sell it for

    /**
     * creates a dialog box and sets up info for future dialog
     * @param speaker the character that is speaking
     */
    public Speech(NPC speaker){
        this.speaker=speaker;
        speakerPersonality =speaker.getPersonality(); //get their personailty to determine what intro
        //they have
        want = 0; //default desire for any item is 0
        mood = NPC.Personality.neutral; //default mood is neutral
    //if the charcater is a nervous character they will have the Mysterious settings where their name is unknown
        if(speakerPersonality== NPC.Personality.nervous){
         display = new DialogBox(speaker, introduction(), speakerPersonality.toString(), true);}
        else{display = new DialogBox(speaker, introduction(), speakerPersonality.toString(), false);}




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

    public void talkAbout(Item item){
        int random= (int)(Math.random()*2);
        switch(random){
            case 1:{
                dialogText = "I want "+item.getName() +" right now...";
                want = 2;
            }
            case 2:{
                dialogText = "I HATE "+item.getName().toUpperCase() +" SO MUCH!!";
                want = 0;
            }
            case 3:{
                dialogText = item.getName() +" is fine";
                want = 1;
            }

        }
    }

    /**
     * change the dialog input the text and current mood
     */
    public void setDialog(){
        display.changeDialog(dialogText,mood.toString());
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

    public int getWant() {
        return want;
    }

    public void addWant() {
        want++;
    }
    public void subtractWant() {
        want--;
    }
}
