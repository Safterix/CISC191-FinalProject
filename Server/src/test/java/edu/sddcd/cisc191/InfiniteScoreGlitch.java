package edu.sddcd.cisc191;

import edu.sdccd.cisc191.template.Characters.Player;

public class InfiniteScoreGlitch extends Thread{

    private Player winner;
    public InfiniteScoreGlitch(Player winner){
        this.winner = winner;
    }

        @Override
        public void run(){
        superWin(100);
        }

    public void superWin(int howMany){
        for(int i = 0; i < howMany; i++) {
            for (int j = 0; j < 100; j++) {
                winner.addScore(1);
                //100
            }
            //10000
        }
    }
}
