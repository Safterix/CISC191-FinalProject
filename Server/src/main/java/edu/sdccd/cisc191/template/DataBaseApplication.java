package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Characters.NPC;
import edu.sdccd.cisc191.template.Characters.Player;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import edu.sdccd.cisc191.template.GameAssets.ViewGame;
import edu.sdccd.cisc191.template.ScoreInfo.PlayerService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class DataBaseApplication extends Application{
//    private static PlayerService playerService = null;
    public ConfigurableApplicationContext springContext;
    private static List<NPC> random;


    public static void main(String[] args) {

        launch(DataBaseApplication.class,args);
    }

public DataBaseApplication(){
}

    @Override
    public void init() {

        springContext = SpringApplication.run(DataBaseApplication.class);
        PlayerService playerService = springContext.getBean(PlayerService.class);

//
        NPC Marky = new NPC("Marky",10,100, (short) 0,"Hai");
        NPC Meowky = new NPC("Meowky",3,100, (short) 0,"Meowmeowmeow.");
        NPC TaoYu = new NPC("Tao Yu",100,100, (short) 50,"Mysterious");
        NPC Creature = new NPC("Creature",10000,100, (short) 0,":3");
        NPC Cat = new NPC("Cat",3,100, (short) 0,"mew.");
        Player noOne = new Player("NoOne");

        playerService.save(Marky);
        playerService.save(Meowky);
        playerService.save(TaoYu);
        playerService.save(Creature);
        playerService.save(Cat);
        playerService.save(noOne);

        random= playerService.findAllNPC();
    }
        @Override
    public void start(Stage primaryStage) {

           PlayerService playerService=springContext.getBean(PlayerService.class);
           random= playerService.findAllNPC();

    }


    public GameButton publishScore(){
        GameButton publishScoreButton = new GameButton("Publish Score?", ViewGame.getScreenDimensions() / 4, ViewGame.getScreenDimensions() / 10, ViewGame.getScreenDimensions() / 30);
            publishScoreButton.setOnAction(event -> {
                PlayerService playerService = springContext.getBean(PlayerService.class);
                playerService.save(ViewGame.getPlayer());
            });
            return publishScoreButton;

    }

    public List<Player> getScores(){
        PlayerService playerService = springContext.getBean(PlayerService.class);
        return playerService.findAllPlayer();
    }

    public List<Player> getScoresOrder(){

        PlayerService playerService = springContext.getBean(PlayerService.class);
        List<Player> sorted = playerService.findAllPlayer();

        sorted.sort(Player::compareTo);
        return sorted;
    }

    public static NPC randomNPC(){
        return random.get((int) (Math.random()*(random.size())));
    }
//
//    public Server inMemoryDBServer() throws SQLException {
//        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
//    }
    @Override
    public void stop() {
        springContext.stop();
    }


    public static void playerJackpot(Player player){
        for (int i = 0; i < 100; i++) {
            player.removeScore(1);
            for (int j = 0; j < 100; j++) {
                player.addScore(1);
            }
        }

    }
}



