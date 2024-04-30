package edu.sdccd.cisc191.scoresDatabase.ScoreInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Score {
    @Id
    private String name;
    private int scoreNumber;

    @OneToMany(fetch = FetchType.EAGER)

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
