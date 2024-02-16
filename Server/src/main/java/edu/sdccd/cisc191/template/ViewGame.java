package edu.sdccd.cisc191.template;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 */
public class ViewGame extends Application
{
    private int sceneWidth;
    private int sceneHeight;
    public static void main(String[] args)
    {
        launch();
    }

    public void start(Stage stage)
    {
        Player player = new Player("Bob", 10, 10);

        PlayerChoice help = new PlayerChoice("Agree");
        PlayerChoice refuse = new PlayerChoice("Refuse");

        Encounter encounter = new Encounter("\"Welcome to Honeywood! My sheep have run amok! Will you help me?\"", help, refuse);
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

        Scene scene = new Scene(encounter);
        stage.setScene(scene);
        stage.show();
    }

    public int getSceneWidth()
    {
        return sceneWidth;
    }
    public int getSceneHeight()
    {
        return sceneHeight;
    }
    public void setScreenDimensions(int width, int height)
    {
        sceneWidth = width;
        sceneHeight = height;
    }
}
