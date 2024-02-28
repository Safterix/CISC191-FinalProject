package edu.sdccd.cisc191.template;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class GameScene extends Scene {
    /**
     * makes gamescene with borderpane
     * @param layout borderpane with eveyrthign inside
     * @param sceneWidth width
     * @param sceneHeight height
     */
    public GameScene(BorderPane layout, int sceneWidth,int sceneHeight){
        super(layout,sceneWidth,sceneHeight);
        getStylesheets().add(getClass().getResource("/fontStyle.css").toExternalForm());
    }
    /**
     * makes gamescene with gridpane
     * @param layout gridpane with eveyrthign inside
     * @param sceneWidth width
     * @param sceneHeight height
     */
    public GameScene(GridPane layout, int sceneWidth, int sceneHeight){
        super(layout,sceneWidth,sceneHeight);
        getStylesheets().add(getClass().getResource("/fontStyle.css").toExternalForm());
    }
}
