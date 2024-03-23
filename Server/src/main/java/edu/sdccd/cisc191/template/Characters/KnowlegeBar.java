package edu.sdccd.cisc191.template.Characters;

import edu.sdccd.cisc191.template.ItemTypes.Knowlege;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.HashSet;

/**
 * seperate bar for knowlege that players learned
 */
public class KnowlegeBar {
    //stores the items in a hashset because there cannot be multiple of the same
    //though redundant since knowlege addresses point to different things...
    private HashSet<Knowlege> learned = new HashSet<Knowlege>();
    private final int knowlegeCount = 4;

    public KnowlegeBar() {
        for(int i=0; i<knowlegeCount; i++){
        learned.add(new Knowlege());}

    }

    public VBox displayKnowlege() {
        VBox bar = new VBox();

        for (Knowlege skill: learned){
            skill.displayItem().setStyle("-fx-border-color: #ab4949");
            bar.getChildren().add(skill.displayItem());
        }
        return bar;
    }
}