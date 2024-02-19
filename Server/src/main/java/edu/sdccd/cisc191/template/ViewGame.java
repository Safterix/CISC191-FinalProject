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
        sceneWidth = 1280;
        sceneHeight = 720;

        //TODO make start button do something lol
        GameButton start = new GameButton("Start", sceneWidth / 2, sceneHeight / 10, "#9FB425");
        //makes credit buttons which leads you to credit scene
        GameButton credits = new GameButton("Credits", sceneWidth / 4, sceneHeight / 10);
        credits.setOnAction((ActionEvent startIt)-> {
            showCredits();
        });
        //makes quit button which exits the window
        GameButton quit = new GameButton("Quit", sceneWidth / 4, sceneHeight / 10, "#AA0C0C");
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it
        VBox buttonsHolder = new VBox(5, start, credits, quit);
        buttonsHolder.setAlignment(Pos.CENTER);

        // add title and subtitle and TODO other labels?
        DefaultText gameTitle  = new DefaultText("Silk Road", sceneWidth/5);
        DefaultText subtitle = new DefaultText("hehehe yaaay", sceneWidth/15);

        //makes borderpane and adds the buttons holder to center
        layout = new BorderPane(buttonsHolder);
        layout.setStyle("-fx-background-color: #CBD4C2");
        //adds title and subtitle to holder and centers at the top
        buttonsHolder = new VBox(sceneHeight/20, gameTitle, subtitle);
        layout.setTop(buttonsHolder);
        buttonsHolder.setAlignment(Pos.CENTER);
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
    /**
     * makes credit page
     */
    public void showCredits() {
        //creates people buttons TODO make it lead to our github pages or somethign?
        GameButton kim = new GameButton("Kim", sceneWidth / 2, sceneHeight / 10, "#9FB425");
        //creates a button to go back to the start screen
        GameButton goBack = new GameButton("Go Back", sceneWidth / 2, sceneHeight / 10, "#AA0C0C");
        goBack.setOnAction((ActionEvent back) -> {
            start(gameStage);
        });
        //adds buttons to a button holder then centers it
        VBox buttonHolder = new VBox(5, kim, goBack);
        buttonHolder.setAlignment(Pos.CENTER);

        //makes borderpane and adds the buttons holder
        layout = new BorderPane(buttonHolder);
        layout.setStyle("-fx-background-color: gray");
        switchScene(new Scene(layout, sceneWidth, sceneHeight), "Credits!");
    }

    /**
     * Sets the scene to a new scene and changes the title
     * @param scene the scene/page that will be switched to
     * @param title the name/title of the page
     */
    public void switchScene(Scene scene, String title){
        gameStage.setScene(scene);
        gameStage.setTitle(title);
    }

}
