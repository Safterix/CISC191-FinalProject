package edu.sdccd.cisc191.template.Networking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdccd.cisc191.template.GameAssets.GameTextArea;

public class ScoreResponse {

    private int score;
    private String name;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(ScoreResponse playerScore) throws Exception {
        return objectMapper.writeValueAsString(playerScore);
    }
    public static ScoreResponse fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, ScoreResponse.class);//converts string into class
    }
    protected ScoreResponse() {};

    public ScoreResponse(int score, String name) {
        this.score = score;
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("%s: %d",name,score);
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    }

