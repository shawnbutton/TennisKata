package com.shawnbutton.tennisScorer;

/**

 */
public class TennisScorer {

    public TennisScore getNewScore(TennisScore score, PlayerEnum playerNumber) {
        if (playerNumber.equals(PlayerEnum.PLAYER1)) {
            if (score.getPlayer1Score() == 0) {
                return new TennisScore(15,0);
            } else if (score.getPlayer1Score() == 15) {
                return new TennisScore(30,0);
            }
        }
        if (score.getPlayer2Score() == 0) {
            return new TennisScore(0,15);
        } else if (score.getPlayer2Score() == 15) {
            return new TennisScore(0,30);
        }

        throw new RuntimeException();
    }
}
