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

/**
 * creates database for NPCs and Playersr
 * npcs are preinitialized with a set of npcs while players
 * must be saved
 */
@SpringBootApplication
public class DataBaseApplication extends Application{
//    private static PlayerService playerService = null;
    public ConfigurableApplicationContext springContext;
    private static List<NPC> random;

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {

        launch(DataBaseApplication.class,args);
    }

public DataBaseApplication(){
}

    /**
     * init all thee NPCs
     */
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

        }
//        PlayerService playerService = springContext.getBean(PlayerService.class);
//        playerService.save(ViewGame.getPlayer());

    /**
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
        @Override
    public void start(Stage primaryStage) {

        random = getNPCs();
    }

    /**
     * creates a publish score button for the game screen that saves the player who just played
     * @return
     */
    public GameButton publishScore(){
        GameButton publishScoreButton = new GameButton("Publish Score?", ViewGame.getScreenDimensions() / 4, ViewGame.getScreenDimensions() / 10, ViewGame.getScreenDimensions() / 30);
            publishScoreButton.setOnAction(event -> {
                PlayerService playerService = springContext.getBean(PlayerService.class);
                playerService.save(ViewGame.getPlayer());
            });
            return publishScoreButton;

    }

    /**
     * gets all the players (unsorted
     * @return list of players
     */
    public List<Player> getScores(){
        PlayerService playerService = springContext.getBean(PlayerService.class);
        return playerService.findAllPlayer();
    }

    /**
     * gets all  the players (sorted by higheest score)
     * @return list of playerrsr
     */
    public List<Player> getScoresOrder(){

        PlayerService playerService = springContext.getBean(PlayerService.class);
        List<Player> sorted = playerService.findAllPlayer();

        sorted.sort(Player::compareTo);
        return sorted;
    }

    /**
     * all NPCS
     * @return all NPCs
     */
    public List<NPC> getNPCs(){
        PlayerService playerService = springContext.getBean(PlayerService.class);
        return playerService.findAllNPC();
    }

    /**
     *
     * @return one random NPC
     */
    public static NPC randomNPC(){
        return random.get((int) (Math.random()*(random.size())));
    }

    /**
     * stops
     */
    public void stop() {
        springContext.stop();
    }
}



