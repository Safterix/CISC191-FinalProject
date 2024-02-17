package edu.sdccd.cisc191.template;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Platform;

/**
 *
 */
public class ViewGame extends Application {

    private int sceneWidth; //this way, the class itself keeps track of the screen's size
    private int sceneHeight;
    private BorderPane layout;
    //so u can switch the scene...
    private Stage gameStage;

    public static void main(String[] args) {
        launch();
    }
    /**
     * creates the start screen
     * @param stage the start screen
     */
    @Override
    public void start(Stage stage) {
        gameStage = stage;
        //sets default scene width and height
        sceneWidth = 1000;
        sceneHeight = 1000;

        //TODO make start button do something lol
        GameButton start = new GameButton("Start", sceneWidth / 2, sceneHeight / 10, Color.GREEN);
        //makes credit buttons which leads you to credit scene
        GameButton credits = new GameButton("Credits", sceneWidth / 4, sceneHeight / 10, Color.YELLOW);
        credits.setOnAction((ActionEvent startIt)-> {
            showCredits();
        });
        //makes quit button which exits the window
        GameButton quit = new GameButton("Quit", sceneWidth / 4, sceneHeight / 10, Color.RED);
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it
        VBox buttonsHolder = new VBox(5, start, credits, quit);
        buttonsHolder.setAlignment(Pos.CENTER);

        //makes borderpane and adds the buttons holder
        layout = new BorderPane(buttonsHolder);
        layout.setStyle("-fx-background-color: #4c4c5b");

        //TODO add title label and other labels?

        //creates scene
        Scene scene = new Scene(layout, sceneWidth, sceneHeight, Color.GRAY);
        stage.setTitle("Silk Road");
        stage.setScene(scene);
        stage.show();

    }

    public int getSceneWidth() {
        return sceneWidth;
    }

    public int getSceneHeight() {
        return sceneHeight;
    }

    /**
     * Sets the screen's size TODO make this actually change the scene's size
     *
     * @param width  new width
     * @param height new height
     */
    public void setScreenDimensions(int width, int height) {
        sceneWidth = width;
        sceneHeight = height;
    }

    public void showCredits() {
        //creates people buttons TODO make it lead to our github pages or somethign?
        GameButton kim = new GameButton("Kim", sceneWidth / 2, sceneHeight / 10, Color.GREEN);
        //creates a button to go back to the start screen
        GameButton goBack = new GameButton("Go Back", sceneWidth / 2, sceneHeight / 10, Color.RED);
        goBack.setOnAction((ActionEvent back) -> {
            start(gameStage);
        });
        //adds buttons to a button holder then centers it
        VBox buttonHolder = new VBox(5, kim, goBack);
        buttonHolder.setAlignment(Pos.CENTER);

        //makes borderpane and adds the buttons holder
        layout = new BorderPane(buttonHolder);
        layout.setStyle("-fx-background-color: gray");
        gameStage.setTitle("Credits!");
        gameStage.setScene(new Scene(layout, sceneWidth, sceneHeight));
    }
}