package edu.sdccd.cisc191.template.GameAssets;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * creates a scene object with specified style sheet, font andd bckground piciture
 */
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

    /**
     * only used with something tht hsa a map bacogrund
     * makes gamescene with borderpane
     * @param layout borderpane with eveyrthign inside
     * @param sceneWidth width
     * @param sceneHeight height
     * @param map  has map background THIS ONE HAS MAP AS BACKGIRUND!!!
     */
    public GameScene(BorderPane layout, int sceneWidth,int sceneHeight,boolean map){
        super(layout,sceneWidth,sceneHeight);
        getStylesheets().add(getClass().getResource("/fontStyle.css").toExternalForm());
        layout.getStylesheets().add("colorPalette.css");
        layout.getStyleClass().add("pane");
        layout.setStyle("-fx-background-size: "+sceneWidth+" "+sceneHeight);
    }

    /**
     * only used with something tht hsa a map bacogrund
     * makes gamescene with gridpane
     * @param layout gridpane with eveyrthign inside
     * @param sceneWidth width
     * @param sceneHeight height
     * @param map  has map background THIS ONE HAS MAP AS BACKGIRUND!!!
     */
    public GameScene(GridPane layout, int sceneWidth, int sceneHeight,boolean map){
        super(layout,sceneWidth,sceneHeight);
        getStylesheets().add(getClass().getResource("/fontStyle.css").toExternalForm());
        layout.getStylesheets().add("colorPalette.css");
        layout.getStyleClass().add("pane");
        layout.setStyle("-fx-background-size: "+sceneWidth+" "+sceneHeight);
    }
}
