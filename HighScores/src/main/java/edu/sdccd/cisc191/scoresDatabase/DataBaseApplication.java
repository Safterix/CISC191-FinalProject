package edu.sdccd.cisc191.scoresDatabase;

import edu.sdccd.cisc191.scoresDatabase.ScoreInfo.Score;
import edu.sdccd.cisc191.scoresDatabase.ScoreInfo.ScoreService;
import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataBaseApplication extends Application{
    public ConfigurableApplicationContext springContext;
    private int sceneWidth, sceneHeight;
    public static void main(String[] args) {
        launch(DataBaseApplication.class, args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        ScoreService scoreService = springContext.getBean(ScoreService.class);


        sceneWidth = ViewGame.getScreenDimensions();
        sceneHeight = (ViewGame.getScreenDimensions()*9)/16;
        GameButton publishScore = new GameButton("Publish Score?", sceneWidth / 4, sceneHeight / 10, sceneWidth / 30);
        publishScore.setOnAction((ActionEvent scoresave) -> {

            });


    }
    public void saveScore(Player player){
        Score score = new Score();
        score.setName(player.getName());
        score.setScoreNumber(player.getScore());

    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }


}
