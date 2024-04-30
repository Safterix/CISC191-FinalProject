package edu.sdccd.cisc191.scoresDatabase.ScoreInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    ScoreRepo scoreRepo;

    public Score save(Score score){
        return scoreRepo.save(score);
    }

}
