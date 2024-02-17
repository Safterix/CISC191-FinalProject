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
    private int sceneWidth; //this way, the class itself keeps track of the screen's size
    private int sceneHeight;
    public static void main(String[] args)
    {
        launch();
    }

    public void start(Stage stage)
    {

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
     * @param width new width
     * @param height new height
     */
    public void setScreenDimensions(int width, int height)
    {
        sceneWidth = width;
        sceneHeight = height;
    }
}
