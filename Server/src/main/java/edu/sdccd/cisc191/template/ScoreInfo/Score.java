package edu.sdccd.cisc191.template.ScoreInfo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Score {
    //unique name and score for a player
    @Id
    private String name;
    private int scoreNumber;

    public Score() {
    }

    public Score(int scoreNumber, String name) {
        this.scoreNumber = scoreNumber;
        this.name = name;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(int scoreNumber) {
        this.scoreNumber = scoreNumber;
    }
}
