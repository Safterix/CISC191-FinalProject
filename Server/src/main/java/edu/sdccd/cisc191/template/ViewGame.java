package edu.sdccd.cisc191.template;


import edu.sdccd.cisc191.template.Characters.Character;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        GameButton start = new GameButton("Start", sceneWidth / 2, sceneHeight / 10, sceneWidth/30);
        start.setOnAction((ActionEvent startIt)->{
            startGame();
        });
        //makes credit buttons which leads you to credit scene
        GameButton credits = new GameButton("Credits", sceneWidth / 4, sceneHeight / 10,sceneWidth/30);
        credits.setOnAction((ActionEvent creditsShow)-> {
            showCredits();
        });
        //makes quit button which exits the window
        GameButton quit = new GameButton("Quit", sceneWidth / 4, sceneHeight / 10, sceneWidth/30);
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it
        VBox buttonsHolder = new VBox(5, start, credits, quit);
        buttonsHolder.setAlignment(Pos.CENTER);

        // add title and subtitle and TODO other labels?
        GameLabel gameTitle  = new GameLabel("Silk Road", sceneWidth/7);
        GameLabel subtitle = new GameLabel("hehehe yaaay", sceneWidth/30);

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
        GameButton kim = new GameButton("Kim", sceneWidth / 2, sceneHeight / 10, sceneWidth/20);
        //creates a button to go back to the start screen
        GameButton goBack = new GameButton("Go Back", sceneWidth / 2, sceneHeight / 10, sceneWidth/25);
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
    public void startGame(){

        //text field that player enters name in next to confirmation button
        TextField namePlayer = new TextField();
        namePlayer.setPrefSize(sceneWidth/2,sceneHeight/5);
        namePlayer.fontProperty().set(new Font("Times New Roman",sceneWidth/25));
        namePlayer.getStylesheets().add("colorPalette.css");
        namePlayer.getStyleClass().add("text-field");

        //puts confirmation button and textfield next to each other and centers it
        GameButton confirm = new GameButton("Confirm", sceneWidth/5,sceneHeight/5,sceneWidth/35);
        HBox nameEnter = new HBox(namePlayer, confirm);
        nameEnter.setAlignment(Pos.CENTER);
        //asks player to enter name label
        GameLabel askPlayer = new GameLabel("What is your name?",sceneWidth/20);
        //sets the layout and scene
        layout = new BorderPane(nameEnter);
        layout.setTop(askPlayer);
        BorderPane.setAlignment(askPlayer,Pos.BOTTOM_CENTER);
        switchScene(new Scene(layout,sceneWidth,sceneHeight), "Begin your adventure...");

        //confirm button will make a player charcter or tell you to try again
        confirm.setOnAction((ActionEvent createCharacter)->{
            if(namePlayer.getText() == null||namePlayer.getText().isEmpty()){
                askPlayer.setText("That is not your name...");
            }
            else{
                Character player = new Character(namePlayer.getText(),100,100);
                //todo do the rest idk...
                switchScene(new Scene(gameScreen(player),sceneWidth,sceneHeight),"yay");
            }

        });


    }
    //todo the basic/ main ui of the game
    public GridPane gameScreen(Character player){
        //playerinfo bottom area
        GridPane wholeUi = new GridPane();
        wholeUi.add(player.getProfile(sceneWidth,sceneHeight), 0,1,1,1);
        //todo add inventor in (2,1)
        //todo map backhtund, npc/event, options, dialog
        StackPane gameEvents;

        return wholeUi;

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
