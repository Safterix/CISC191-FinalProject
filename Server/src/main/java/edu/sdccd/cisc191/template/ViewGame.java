package edu.sdccd.cisc191.template;


import edu.sdccd.cisc191.template.Characters.Character;
import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.ItemTypes.Heal;
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

import static edu.sdccd.cisc191.template.GameScreen.defaultScreen;

/**
 *
 */
public class ViewGame extends Application {

    //default size
    private int sceneWidth=0; //this way, the class itself keeps track of the screen's size
    private int sceneHeight=0;
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
        if((sceneWidth==0)&&(sceneHeight==0)){
            sceneWidth=1280;
            sceneHeight=720;
        }

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
        GameButton settings = new GameButton("Settings",sceneWidth/4,sceneHeight/10,sceneWidth/30);
        settings.setOnAction((ActionEvent settingsShow)->{
            showSettings();
        });
        //makes quit button which exits the window
        GameButton quit = new GameButton("Quit", sceneWidth / 4, sceneHeight / 10, sceneWidth/30);
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it
        VBox buttonsHolder = new VBox(5, start, credits,settings, quit);
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
        stage.resizableProperty().set(false);
        stage.show();

    }


    /**
     * Sets the screen's size TODO make this actually change the scene's size IDK HWO TO DO THIS
     *TODO
     * @param width  new width
     * @param height new height
     */
    public void setScreenDimensions(int width, int height) {
        sceneWidth = width;
        sceneHeight = height;
        start(gameStage);
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

    /**
     * TODO SETTINSG APGE TO CHANGE SCREEN IDK HW TO DO THIS
     */
    public void showSettings() {
        //creates window options
        GameButton smallerSize = new GameButton("640x360", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        smallerSize.setOnAction((ActionEvent size360p) -> {
            setScreenDimensions(640 ,360);
        });
        GameButton defautlSize = new GameButton("1280x720", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        defautlSize.setOnAction((ActionEvent size720p) -> {
            setScreenDimensions(1280,720);
        });
        GameButton biggerSize = new GameButton("1920x1080", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        biggerSize.setOnAction((ActionEvent size1080p) -> {
            setScreenDimensions(1920,1080);
        });

        //creates a button to go back to the start screen
        GameButton goBack = new GameButton("Go Back", sceneWidth / 2, sceneHeight / 10, sceneWidth / 25);
        goBack.setOnAction((ActionEvent back) -> {
            start(gameStage);
        });

        //adds buttons to a button holder then centers it
        VBox buttonHolder = new VBox(5, smallerSize, defautlSize,biggerSize,goBack);
        buttonHolder.setAlignment(Pos.CENTER);

        //makes borderpane and adds the buttons holder
        layout = new BorderPane(buttonHolder);
        layout.setStyle("-fx-background-color: gray");
        switchScene(new Scene(layout, sceneWidth, sceneHeight), "Settings!");
    }
    public void startGame(){

        //text field that player enters name in next to confirmation button
        TextField namePlayer = new TextField();
        namePlayer.setPrefSize(sceneWidth/2,sceneHeight/5);
        namePlayer.fontProperty().set(new Font("Times New Roman",sceneWidth/25));
        namePlayer.getStylesheets().add("colorPalette.css");
        namePlayer.getStyleClass().add("text-field");


        //TODO DELETE LATER ITEM TEST ONLY
        Heal test = new Heal(Heal.HealingItems.GINSENG);
        GameButton lala = test.displayItem(sceneHeight/10);


        //puts confirmation button and textfield next to each other and centers it
        GameButton confirm = new GameButton("Confirm", sceneWidth/5,sceneHeight/5,sceneWidth/35);
        HBox nameEnter = new HBox(namePlayer, confirm,lala); //TODO DELTE ITEM TEST ONLY
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
                Player player = new Player(namePlayer.getText(),100,100,0);
                //todo do the rest idk...
                switchScene(new Scene(defaultScreen(player,sceneWidth/30),sceneWidth,sceneHeight),"yay");
            }

        });


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
