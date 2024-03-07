package edu.sdccd.cisc191.template.GameAssets;


import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.ItemTypes.Heal;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.io.*;

import static edu.sdccd.cisc191.template.GameAssets.GameScreen.defaultScreen;

/**
 *
 */
public class ViewGame extends Application {

    //default size
    private static int sceneWidth = 0; //this way, the class itself keeps track of the screen's size
    private static int sceneHeight = 0;
    private static BorderPane layout;
    //so u can switch the scene...
    private static Stage gameStage;
    private static Player player;

    public static void main(String[] args) {
        launch();
    }

    /**
     * creates the start screen
     *
     * @param stage the start screen
     */
    @Override
    public void start(Stage stage) {

        gameStage = stage;
        if ((sceneWidth == 0) && (sceneHeight == 0)) {
            sceneWidth = 1280;
            sceneHeight = 720;
        }

        GameButton start = new GameButton("Start", sceneWidth / 2, sceneHeight / 10, sceneWidth / 30);
        start.setOnAction((ActionEvent startIt) -> {
            startGame();
        });
        //makes credit buttons which leads you to credit scene
        GameButton credits = new GameButton("Credits", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        credits.setOnAction((ActionEvent creditsShow) -> {
            showCredits();
        });
        GameButton settings = new GameButton("Settings", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        settings.setOnAction((ActionEvent settingsShow) -> {
            showSettings();
        });
        //makes quit button which exits the window
        GameButton quit = new GameButton("Quit", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it
        VBox buttonsHolder = new VBox(5, start, credits, settings, quit);
        buttonsHolder.setAlignment(Pos.CENTER);

        // add title and subtitle
        GameLabel gameTitle = new GameLabel("Silk Road", sceneWidth / 7);
        GameLabel subtitle = new GameLabel("hehehe yaaay", sceneWidth / 30);

        //makes borderpane and adds the buttons holder to center
        layout = new BorderPane(buttonsHolder);
        layout.setStyle("-fx-background-color: #CBD4C2");
        //adds title and subtitle to holder and centers at the top
        buttonsHolder = new VBox(sceneHeight / 20, gameTitle, subtitle);
        layout.setTop(buttonsHolder);
        buttonsHolder.setAlignment(Pos.CENTER);
        //creates scene
        Scene scene = new GameScene(layout, sceneWidth, sceneHeight);
        stage.setTitle("Silk Road");
        stage.setScene(scene);
        stage.resizableProperty().set(false);
        stage.show();

    }


    /**
     * Sets the screen's size
     *
     * @param width  new width
     * @param height new height
     */
    public void setScreenDimensions(int width, int height) {
        sceneWidth = width;
        sceneHeight = height;
        start(gameStage);
    }

    public static int getScreenDimensions() {
        return sceneWidth;
    }

    public static Stage getStage() {
        return gameStage;
    }

    /**
     * makes credit page
     */
    public void showCredits() {
        //creates people buttons TODO make it lead to our github pages or somethign?
        GameButton kim = new GameButton("Kim", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        GameButton angeliz = new GameButton("angeliz", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        //creates a button to go back to the start screen
        GameButton goBack = new GameButton("Go Back", sceneWidth / 2, sceneHeight / 10, sceneWidth / 25);
        goBack.setOnAction((ActionEvent back) -> {
            start(gameStage);
        });
        //adds buttons to a button holder then centers it
        VBox buttonHolder = new VBox(5, angeliz, kim, goBack);
        buttonHolder.setAlignment(Pos.CENTER);

        //makes borderpane and adds the buttons holder
        layout = new BorderPane(buttonHolder);
        layout.setStyle("-fx-background-color: gray");
        switchScene(new GameScene(layout, sceneWidth, sceneHeight), "Credits!");
    }

    /**
     *
     */
    public void showSettings() {
        //creates window options
        GameButton smallerSize = new GameButton("640x360", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        smallerSize.setOnAction((ActionEvent size360p) -> {
            setScreenDimensions(640, 360);
        });
        GameButton defautlSize = new GameButton("1280x720", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        defautlSize.setOnAction((ActionEvent size720p) -> {
            setScreenDimensions(1280, 720);
        });
        GameButton biggerSize = new GameButton("1920x1080", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        biggerSize.setOnAction((ActionEvent size1080p) -> {
            setScreenDimensions(1920, 1080);
        });

        //creates a button to go back to the start screen
        GameButton goBack = new GameButton("Go Back", sceneWidth / 2, sceneHeight / 10, sceneWidth / 25);
        goBack.setOnAction((ActionEvent back) -> {
            start(gameStage);
        });

        //adds buttons to a button holder then centers it
        VBox buttonHolder = new VBox(5, smallerSize, defautlSize, biggerSize, goBack);
        buttonHolder.setAlignment(Pos.CENTER);

        //makes borderpane and adds the buttons holder
        layout = new BorderPane(buttonHolder);
        layout.setStyle("-fx-background-color: gray");
        switchScene(new GameScene(layout, sceneWidth, sceneHeight), "Settings!");
    }

    public static void startGame() {

        //text field that player enters name in next to confirmation button
        TextField namePlayer = new TextField();
        namePlayer.setPrefSize(sceneWidth / 2, sceneHeight / 5);
        namePlayer.getStylesheets().add("colorPalette.css");
        namePlayer.getStyleClass().add("text-field");


        //puts confirmation button and textfield next to each other and centers it
        GameButton confirm = new GameButton("Confirm", sceneWidth / 5, sceneHeight / 5, sceneWidth / 35);
        HBox nameEnter = new HBox(namePlayer, confirm);
        nameEnter.setAlignment(Pos.CENTER);
        //asks player to enter name label
        GameLabel askPlayer = new GameLabel("What is your name?", sceneWidth / 20);
        //sets the layout and scene
        layout = new BorderPane(nameEnter);
        layout.setTop(askPlayer);
        BorderPane.setAlignment(askPlayer, Pos.BOTTOM_CENTER);
        switchScene(new GameScene(layout, sceneWidth, sceneHeight), "Begin your adventure...");


        //confirm button will make a player charcter or tell you to try again
        confirm.setOnAction((ActionEvent createCharacter) -> {
            if (namePlayer.getText() == null || namePlayer.getText().isEmpty()) {
                askPlayer.setText("That is not your name...");
            } else {
                player = new Player(namePlayer.getText(), 100, 100, (short) 0);
                switchScene(new GameScene(defaultScreen(player, sceneWidth, sceneHeight), sceneWidth, sceneHeight), "yay");
            }

        });


    }

    /**
     * Sets the scene to a new scene and changes the title
     *
     * @param scene the scene/page that will be switched to
     * @param title the name/title of the page
     */
    public static void switchScene(GameScene scene, String title) {
        gameStage.setScene(scene);
        gameStage.setTitle(title);
    }

    //game end
    public static void endGame() {
        GameButton save = new GameButton("Save", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        save.setOnAction((ActionEvent saveAchievements) -> {
            save();
        });
        GameButton tryAgain = new GameButton("Try Again", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        tryAgain.setOnAction((ActionEvent playAgain) -> {
            startGame();
        });

        GameButton quit = new GameButton("Quit", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it
        HBox buttonsHolder = new HBox(5, save, tryAgain, quit);
        buttonsHolder.setAlignment(Pos.CENTER);

        GameLabel gameOver = new GameLabel("GAME OVER", sceneWidth / 7);
        GameLabel subtitle = new GameLabel("YOU WIN! SCORE:" + player.getScore(), sceneWidth / 30);
        VBox titlesHolder = new VBox(sceneHeight / 20, gameOver, subtitle);
        titlesHolder.setAlignment(Pos.CENTER);
        //makes borderpane and adds the buttons holder to center
        layout = new BorderPane(titlesHolder);
        layout.setStyle("-fx-background-color: #CBD4C2");
        layout.setBottom(buttonsHolder);


        buttonsHolder.setAlignment(Pos.CENTER);


        if (player.getHealth() == 0) {
            subtitle.setText("YOU DIED...SCORE:" + player.getScore());
        }
        //creates scene
        GameScene scene = new GameScene(layout, sceneWidth, sceneHeight);
        switchScene(scene, "The End");

    }

    //TODO use some kind of i/O to save Score and achievemenst (TBD )

    /**
     * saves the score and TODO achievements that a player got thru a game session
     * uses FileChooser for user to pick where to save the TXT file
     */
    public static void save() {
        //can only make txt files
        FileChooser.ExtensionFilter textFiles = new FileChooser.ExtensionFilter("Text Files", "*txt");
        //setup filechooser, defualt file is My_Silk_Road_Score.txt
        FileChooser fc = new FileChooser();
        fc.setTitle("Save your Score!");
        fc.setInitialFileName("My_Silk_Road_Score.txt");
        fc.getExtensionFilters().add(textFiles);
        //set the file that will the score will be saved to
        File saveLocation = fc.showSaveDialog(gameStage);
        //intialize pw to write on txt file
        PrintWriter output;
        //try to make a printwriter with saveLocation but must catch filenotfoundexecption
        try {
            output = new PrintWriter(saveLocation);

        }
        catch (FileNotFoundException e) {
            //  cant write to file, alert (if user closes out)
            Alert errorAlert = new Alert(Alert.AlertType.ERROR,
                    "Sorry!! An error occurred while" +
                            "trying to save your score... Try again!");
            errorAlert.showAndWait();
            return;
        }

            //write to output file
            output.write("Thank you for playing the silk road game!\nIn your recent run as " + player.getName() +
                    ", you played GOAL. You got " + player.getScore() + " points! Good Job!\n\n" +
                    "Your Achievements:\n");
            output.close();


    }
    }
