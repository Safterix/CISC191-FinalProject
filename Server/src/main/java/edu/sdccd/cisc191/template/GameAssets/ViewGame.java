package edu.sdccd.cisc191.template.GameAssets;


import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.Networking.Client;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.Platform;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static edu.sdccd.cisc191.template.GameAssets.GameScreen.defaultScreen;

/**
 *the starting screens of the game, includes start page, settings, credits and the starting of the game
 */
public class ViewGame extends Application {

    private Media media = new Media(getClass().getResource("/chinabgm.mp3").toString()); //music file
    // Create a MediaPlayer with the Media object
    private MediaPlayer mediaPlayer = new MediaPlayer(media);
    private boolean isPlaying;
    protected static int sceneWidth = 0; //this way, the class itself keeps track of the screen's size
    private  static int sceneHeight = 0;
    private BorderPane layout;//so u can switch the scene...
    private static Stage gameStage;//the stage so u can switch it
    private static Player player;//player when the player makes themselves
    private  String scoresHolder; // TODO make this string array instead and make it work
    public static Client client = new Client(); //for networking and highscore
    private File scores = new File(getClass().getResource("/Scores.txt").getPath());
    //TODO eventualyl for networking and high scores....an attempt was made...
    public ViewGame(){};
    /**
     * app lauch
     * @param args app launch
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * creates the start screen
     *includes start button, credits ,settings, and quit button  that direct you to different scenes
     * @param stage the start screen
     */
    @Override
    public void start(Stage stage) {
        // Lower the volume of BGM (0.05 means 5% of maximum volume)
        mediaPlayer.setVolume(0.05);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); //loop music
        mediaPlayer.play(); //playmusic



        //add this to the main at start stage
        //default size of the stage/window is 1280x720px
        //this is for when you switch the size to something else usign settings it will stay correct!
        gameStage = stage;
        if ((sceneWidth == 0) && (sceneHeight == 0)) {
            sceneWidth = 1280;
            sceneHeight = 720;
        }
        //creates start button which starts the game using startGame()
        GameButton start = new GameButton("Start", sceneWidth / 2, sceneHeight / 12, sceneWidth / 30);
        start.setOnAction((ActionEvent startIt) -> {
            startGame();
        });
        //makes credit buttons which leads you to credit scene, using showCredits()
        GameButton credits = new GameButton("Credits", sceneWidth / 4, sceneHeight / 12, sceneWidth / 30);
        credits.setOnAction((ActionEvent creditsShow) -> {
            showCredits();
        });
        //creatures setting button that leads you to settings scene, using showSettings
        GameButton settings = new GameButton("Settings", sceneWidth / 4, sceneHeight / 12, sceneWidth / 30);
        settings.setOnAction((ActionEvent settingsShow) -> {
            showSettings();
        });
        //makes quit button which exits the window
        GameButton quit = new GameButton("Quit", sceneWidth / 6, sceneHeight / 15, sceneWidth / 45);
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it, adds all the four buttons
        VBox buttonsHolder = new VBox(5, start, credits, settings, quit);
        buttonsHolder.setAlignment(Pos.CENTER);

        // add title and subtitle using gameLabels
        GameLabel gameTitle = new GameLabel("Silk ", sceneWidth / 5,"fancy");
        GameLabel gameTitle2 = new GameLabel("Road", sceneWidth / 5,"fancy");
        //makes the Silk part of silkroad a different color, TODO temp just for visuals because it is hard to read
        gameTitle.setStyle("-fx-text-fill:#523249  ; -fx-font-size: "+sceneWidth/5);
        //makes it so the Silk and the Road are togetehr
        HBox title = new HBox(gameTitle,gameTitle2);
        title.setAlignment(Pos.CENTER);
        //subtitle is just normal
        GameLabel subtitle = new GameLabel("hehehe yaaay", sceneWidth / 30);

        //makes borderpane and adds the buttons
        layout = new BorderPane(buttonsHolder);
        //adds title and subtitle to holder and centers at the top
        buttonsHolder = new VBox(sceneHeight / 20, title, subtitle);
        layout.setTop(buttonsHolder);
        buttonsHolder.setAlignment(Pos.CENTER);
        //creates  a GAMEscene with a map as the background
        GameScene scene = new GameScene(layout, sceneWidth, sceneHeight,true);
        //sets stage title and to the scene
        gameStage.setTitle("Silk Road");
        gameStage.setScene(scene);
        //cannot resize so that the settings will work...
        gameStage.resizableProperty().set(false);
        //shows the stage
        gameStage.show();

    }


    /**
     * Sets the screen's size and goes back to the start screen
     *
     * @param width  new width
     * @param height new height
     */
    public void setScreenDimensions(int width, int height) {
        sceneWidth = width;
        sceneHeight = height;
        start(gameStage);
    }

    /**
     * returns the scenewidth so the other gameAssets can use it
     * @return
     */
    public static int getScreenDimensions() {
        return sceneWidth;
    }

    public Stage getStage() {
        return gameStage;
    }

    /**
     * makes credit page
     */
    protected void showCredits() {
        //creates people buttons TODO make it lead to our github pages or somethign?
        GameButton kim = new GameButton("Kim", sceneWidth / 2, sceneHeight / 30, sceneWidth / 30);
       kim.setOnAction((ActionEvent goToKim)->{
           goToGithub("kimwong000");
       });
        GameButton angeliz = new GameButton("Angeliz", sceneWidth / 2, sceneHeight / 30,sceneWidth / 30);
        angeliz.setOnAction((ActionEvent goToAngeliz)->{
            goToGithub("angelizn");
        });
        GameButton kyle = new GameButton("Kyle", sceneWidth / 2, sceneHeight / 30,sceneWidth / 30);
        kyle.setOnAction((ActionEvent goToKyle)->{
            goToGithub("KyleNNguyen");
        });
        GameButton aleister = new GameButton("Aleister", sceneWidth / 2, sceneHeight / 30,sceneWidth / 30);
        aleister.setOnAction((ActionEvent goToAleister)->{
            goToGithub("safterix");
        });
        GameButton jason = new GameButton("Jason", sceneWidth / 2, sceneHeight / 30,sceneWidth / 30);
        jason.setOnAction((ActionEvent goToJason)->{
            goToGithub("jasonphan1234");
        });
        //creates a button to go back to the start screen
        GameButton goBack = new GameButton("Go Back", sceneWidth / 2, sceneHeight / 30, sceneWidth / 25);
        goBack.setOnAction((ActionEvent back) -> {
            start(gameStage);
        });
        //adds buttons to a button holder then centers it
        VBox buttonHolder = new VBox(5, aleister, angeliz, jason, kim, kyle, goBack);
        buttonHolder.setAlignment(Pos.CENTER);

        //makes borderpane and adds the buttons holder
        layout = new BorderPane(buttonHolder);
        switchScene(new GameScene(layout, sceneWidth, sceneHeight), "Credits!");
    }

    /**
     * tries to opens the link to our github page
     * @param username of our github account
     */
    public static void goToGithub(String username) {
        URI openLink;
        try {
            //turn the URL to our github into a URI
            URL lala = new URL("https://github.com/"+username);
            openLink = lala.toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        //is desktop supported? yes -> get desktop, no null
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(openLink);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *show the settings which only has size options for now
     * TODO audio slider
     */
    protected void showSettings() {
        //creates window options first 640x360px that sets screen dimensions to tat
        GameButton smallerSize = new GameButton("640x360", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        smallerSize.setOnAction((ActionEvent size360p) -> {
            setScreenDimensions(640, 360);
        });
        //sets screendimensions to 1280x 720 p
        GameButton defautlSize = new GameButton("1280x720", sceneWidth / 2, sceneHeight / 10, sceneWidth / 20);
        defautlSize.setOnAction((ActionEvent size720p) -> {
            setScreenDimensions(1280, 720);
        });
        //sets screendimensions to 1920x720p
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

    /**
     * starts the game by asking the player for their name
     * makes a Player with their name with the default stats
     */
    protected void startGame() {

        //text field that player enters name in next to confirmation button
        TextField namePlayer = new TextField();
        namePlayer.setPrefSize(sceneWidth / 2, sceneHeight / 5);
        namePlayer.getStylesheets().add("colorPalette.css");
        namePlayer.getStyleClass().add("text-field");
        namePlayer.setStyle("-fx-font-size: "+ ViewGame.getScreenDimensions()/20);

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
        //sets the scene with all of this
        switchScene(new GameScene(layout, sceneWidth, sceneHeight), "Begin your adventure...");


        //confirm button will make a player charcter or tell you to try again
        confirm.setOnAction((ActionEvent createCharacter) -> {
            String name = namePlayer.getText();//get the name of the palyer from the text field

            if (name == null || name.isEmpty()) {
                askPlayer.setText("That is not your name...");//if name is empty NO
            }
            else if(name.length()>8){
                askPlayer.setText("Your name is too long..."); //if name is more than 8 char NO
            }
            else if(name.length()<2){
                askPlayer.setText("Your name is too short...");//if name is less than 2 char NO
            }
           else if( !name.matches("[a-zA-Z]+")){
                    askPlayer.setText("Your name can only have letters...");} //if name has non chars NO

            else{//if it is allowed make player
            player = new Player(namePlayer.getText());


            //TODO TEMP just makes an NPC for now to display the GameScreen as demo
                //TODO all of the gamescene settings have an NPC on it for demo yes
                NPC notPlayer = new NPC();

                //asks the player for their goal
                GameTextArea goal = new GameTextArea("What is your goal in life...?","nervous");
                goal.setMaxSize(sceneWidth/2,sceneHeight/3);
                goal.setPrefSize(sceneWidth/2,sceneHeight/3);
                //makes money option that sets gaol to making a lot of money
                GameButton moneyGoal = new GameButton("Make lots of money", sceneWidth / 3, sceneHeight / 10, sceneWidth / 30);
                moneyGoal.setOnAction((ActionEvent setMoneyGoal) -> {
                    player.setGoal("Make lots of money");
                    switchScene(new GameScene(defaultScreen(player, notPlayer, sceneWidth, sceneHeight), sceneWidth, sceneHeight,true), "yay");
                });
                //makes exploration otpion that sets goal to exploring
                GameButton explore = new GameButton("Explore the world", sceneWidth / 3, sceneHeight / 10, sceneWidth / 30);
                explore.setOnAction((ActionEvent setExploreGoal) -> {
                    player.setGoal("Explore the world");
                    switchScene(new GameScene(defaultScreen(player, notPlayer, sceneWidth, sceneHeight), sceneWidth, sceneHeight,true), "yay");
                });
                //make fame button that sets goal to being famous
                GameButton fame = new GameButton("Become famous", sceneWidth / 3, sceneHeight / 10, sceneWidth / 30);
                fame.setOnAction((ActionEvent fameREp) -> {
                    player.setGoal("Become famous");
                    switchScene(new GameScene(defaultScreen(player, notPlayer, sceneWidth, sceneHeight), sceneWidth, sceneHeight,true), "yay");
                });
                //sets the layout so u can see the question and buttons
                HBox goals = new HBox(moneyGoal,explore,fame);
                layout.getChildren().remove(askPlayer);
                layout.setCenter(goal);
                layout.setBottom(goals);
                 }});
                }


    /**
     * Sets the scene to a new scene and changes the title
     *
     * @param scene the scene/page that will be switched to
     * @param title the name/title of the page
     */
    protected void switchScene(GameScene scene, String title) {

        gameStage.setScene(scene);
        gameStage.setTitle(title);
    }

    /**
     * the game end screen, has a save, try again, and quit button
     * TODO also has a publish score button that is WIP networking
     */
    public void endGame() {
        //makes save button that calls save() to save your score
        GameButton save = new GameButton("Save", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        save.setOnAction((ActionEvent saveAchievements) -> {
            save();
        });
        //makes try again button that sends you back to the start screen back to when u started game...
        GameButton tryAgain = new GameButton("Try Again", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        tryAgain.setOnAction((ActionEvent playAgain) -> {
            restart();
        });
        //makes quit button that closes agme
        GameButton quit = new GameButton("Quit", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        quit.setOnAction((ActionEvent exit) -> {
            Platform.exit();
        });

        //makes holder for the buttons and centers it
        HBox buttonsHolder = new HBox(5, save, tryAgain, quit);
        buttonsHolder.setAlignment(Pos.CENTER);
        //sets the text telling u GAME OVER! and telling ur screo
        GameLabel gameOver = new GameLabel("GAME OVER", sceneWidth / 7);
        GameLabel subtitle = new GameLabel("YOU WIN! SCORE:" + player.getScore(), sceneWidth / 30);
        VBox titlesHolder = new VBox(sceneHeight / 20, gameOver, subtitle);


        //if u died instead of making it, it will say you died instead lol
        if (player.getHealth() == 0) {
            subtitle.setText("YOU DIED...SCORE:" + player.getScore());
        }
        titlesHolder.setAlignment(Pos.CENTER);
        //makes borderpane and adds the buttons holder to center
        layout = new BorderPane(titlesHolder);
        layout.setStyle("-fx-background-color: #CBD4C2");
        layout.setBottom(buttonsHolder);

//
//        GameButton highscore = new GameButton("Publish Score?", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
//        highscore.setOnAction((ActionEvent scoresave) -> {
//            makeHighScore();
//            highscore.setText("Thank you!");
//            highscore.setOnAction(null);
//            });
//
        //TODO HIGH SCORE
        GameButton highscore = new GameButton("Publish Score?", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        highscore.setOnAction((ActionEvent scoresave) -> {

            try { //client send request with player info and get player info back but formated
                //useless networking
                client.startConnection("127.0.0.1", 6000 );
                makeHighScore(client.sendRequest(player.getName(), player.getScore()).toString());
                System.out.println(client.sendRequest(player.getName(), player.getScore()).toString());
                client.stopConnection();
                highscore.setText("Thank you!");
                   highscore.setOnAction(null);
            } catch(Exception e) {
                e.printStackTrace();
            }

        });
        layout.setTop(highscore);


        //creates scene
        GameScene scene = new GameScene(layout, sceneWidth, sceneHeight);
        switchScene(scene, "The End");

    }

    /**
     * restart the game by using start()
     * but first mute and stop the music so it can start again!
     */
    private void restart() {
        mediaPlayer.setMute(true);
        mediaPlayer.stop();
        start(gameStage);
    }


    /**
     * saves the score and TODO achievements that a player got thru a game session
     * uses FileChooser for user to pick where to save the TXT file
     */
    public void save() {
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
        writeFile(player,saveLocation);


    }

    /**
     * writes to a file player information
     * @param playername player that information will be taken from
     * @param saveLocation the file that is saved to
     */
    public void writeFile( Player playername,File saveLocation){
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
        output.write("Thank you for playing the silk road game!\nIn your recent run as " + playername.getName() +
                ", you wanted to "+playername.getGoal().toLowerCase()+". You got " + playername.getScore() + " points! Good Job!\n\n" +
                "Your Achievements:\n");
        output.close();
    }
    /**
     * TODO writes your highscore to the file, need to sort from high to low!
     * TODO writes to a Target file not sure what that is rn...
     *  TODO have string array....
     */
    public void makeHighScore(String score) {
        scoresHolder = score;

//        System.out.print(scores.canWrite());
//        try {
//            PrintWriter out = new PrintWriter(new FileWriter(scores));
//            out.write(string);
//            out.close();
//            System.out.print("i have written");
//        } catch (IOException e) {
//            e.printStackTrace(); }

            }

    /**
     * returns the scores TODO rn just a string but will be string array
     * @return
     */
    public String getScoresHolder(){
        return scoresHolder;
    }

    }
