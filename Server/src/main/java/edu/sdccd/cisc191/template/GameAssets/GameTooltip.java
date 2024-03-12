package edu.sdccd.cisc191.template.GameAssets;

import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class GameTooltip extends Tooltip {

    public GameTooltip(String NPCDesc){
        setText(NPCDesc);
        setStyle("-fx-font-size: "+ViewGame.getScreenDimensions()/60+";-fx-background-color: #CBD4C2; -fx-border-color: #523249;"+
                "-fx-text-fill: #815355; -fx-border-width: 5");
        setShowDelay(Duration.millis(20));
    }

    public GameTooltip(boolean item, String desc){
        setText(desc);
        setStyle("-fx-font-size: "+ViewGame.getScreenDimensions()/45+";-fx-background-color: #CBD4C2; -fx-border-color: #523249;"+
                "-fx-text-fill: #815355; -fx-border-width: 5");
        setShowDelay(Duration.millis(20));
    }
}
