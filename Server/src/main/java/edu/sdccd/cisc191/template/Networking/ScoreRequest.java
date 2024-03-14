package edu.sdccd.cisc191.template.Networking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdccd.cisc191.template.GameAssets.GameButton;
import edu.sdccd.cisc191.template.GameAssets.GameTextArea;
import javafx.scene.layout.HBox;

public class ScoreRequest {


    private String name;
    private int score;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(ScoreRequest player) throws Exception {
        return objectMapper.writeValueAsString(player);
    }
    public static ScoreRequest fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, ScoreRequest.class);
    }

    protected ScoreRequest() {};
    public ScoreRequest(String name,int score){
        this.name =name;
        this.score=score;
    }

    @Override
    public String toString() {
        return String.format("%s: %d",name,score);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
