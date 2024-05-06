package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.ScoreInfo.PlayerService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class DataBaseApplication extends Application{
    public ConfigurableApplicationContext springContext;
    private static GameButton publishScore;


    public static void main(String[] args) {

        launch(DataBaseApplication.class, args);
    }

public DataBaseApplication(){}
    @Override
    public void init() {
        springContext = SpringApplication.run(DataBaseApplication.class);
        PlayerService playerService = springContext.getBean(PlayerService.class);
        playerService.save(ViewGame.getPlayer());
    }
        @Override
    public void start(Stage primaryStage) {

//makes button that asks if u want to publish score
        int sceneWidth = (int) primaryStage.getWidth();
        int sceneHeight = (int) primaryStage.getHeight();
        publishScore = new GameButton("Publish Score?", (sceneWidth / 4), (sceneHeight / 10), (sceneWidth /30));
            publishScore.setOnAction(event -> {
                init();
                PlayerService playerService = springContext.getBean(PlayerService.class);
                playerService.save(ViewGame.getPlayer());
                for(Player player: playerService.findAll()){
                    System.out.print(player.toString());
                }
            });

    }


    @Override
    public void stop() {
        springContext.stop();
    }

public static GameButton getPublishButton(){
    return publishScore;
}
    public Server inMemoryDBServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");

    }
}



