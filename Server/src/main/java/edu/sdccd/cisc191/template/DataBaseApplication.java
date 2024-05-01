package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.ScoreInfo.Score;
import edu.sdccd.cisc191.template.ScoreInfo.ScoreService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataBaseApplication extends Application{
    public ConfigurableApplicationContext springContext;
    private GameButton publishScore;


    public static void main(String[] args) {

        launch(DataBaseApplication.class, args);
    }

public DataBaseApplication(){}
    @Override
    public void init() {
        springContext = SpringApplication.run(DataBaseApplication.class);
    }
        @Override
    public void start(Stage primaryStage) {
        ScoreService scoreService = springContext.getBean(ScoreService.class);
//makes button that asks if u want to publish score
        int sceneWidth = (int) primaryStage.getWidth();
        int sceneHeight = (int) primaryStage.getHeight();
        publishScore = new GameButton("Publish Score?", (sceneWidth / 4), (sceneHeight / 10), (sceneWidth /30));
        publishScore.setOnAction((ActionEvent scoreSave) -> scoreService.save(saveScore(ViewGame.getPlayer())));

    }

    public Score saveScore(Player player){
        Score score = new Score();
        score.setName(player.getName());
        score.setScoreNumber(player.getScore());
        return score;
    }

    @Override
    public void stop() {
        springContext.stop();
    }

public GameButton getPublishButton(){
    return publishScore;
}

}



