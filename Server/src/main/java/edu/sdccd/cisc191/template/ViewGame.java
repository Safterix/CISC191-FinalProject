package edu.sdccd.cisc191.template;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 */
public class ViewGame extends Application
{
    private int sceneWidth; //this way, the class itself keeps track of the screen's size
    private int sceneHeight;
    public static void main(String[] args)
    {
        launch();
    }

    public void start(Stage stage)
    {
        testEncounter(stage); //TODO make all encounters leave once they are done (somehow)
    }

    /**
     * Code to create a mock encounter
     * @param stage
     */
    private void testEncounter(Stage stage) //TODO: delete this method
    {
        //create a mock player
        Player player = new Player("Bob", 10, 10);

        //create two choices for the encounter
        GameButton help = new GameButton("Agree");
        GameButton refuse = new GameButton("Refuse");

        //create the encounter
        Encounter encounter = new Encounter("\"Welcome to Honeywood! My sheep have run amok! Will you help me?\"", help, refuse);

        //set the consequences of the chocies
        help.setOnAction(event -> {
            player.gainMoney(5);
            System.out.println("Money:" + player.getMoney());
            encounter.updateText("\"Thank you adventurer! Here, have some money.");
        });
        refuse.setOnAction(event -> {
            player.hurt(3);
            encounter.updateText("He punches you in the face.");
            System.out.println("Health:" + player.getHealth());
        });

        //show
        Scene scene = new Scene(getEncounterView(encounter));
        stage.setScene(scene);
        stage.show();
    }

    public VBox getEncounterView(Encounter encounter)
    {
        VBox vBox = new VBox();

        Label label = encounter.getTextLabel();
        HBox hBox = new HBox(encounter.getChoices());
        vBox.getChildren().addAll(label, hBox);

        return vBox;
    }

    public int getSceneWidth()
    {
        return sceneWidth;
    }
    public int getSceneHeight()
    {
        return sceneHeight;
    }

    /**
     * Sets the screen's size TODO make this actually change the scene's size
     * @param width
     * @param height
     */
    public void setScreenDimensions(int width, int height)
    {
        sceneWidth = width;
        sceneHeight = height;
    }
}
