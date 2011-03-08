package com.shawnbutton.tennisScorer;

/**

 */
public class TennisScore {
    private int player1Score;
    private int player2Score;

//    public int getPlayer1Score() {
//        return player1Score;
//    }
//
//    public int getPlayer2Score() {
//        return player2Score;
//    }

    public TennisScore(int player1, int player2) {
        player1Score = player1;
        player2Score = player2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TennisScore that = (TennisScore) o;

        if (player1Score != that.player1Score) return false;
        if (player2Score != that.player2Score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = player1Score;
        result = 31 * result + player2Score;
        return result;
    }

    public Boolean isWinner() {
        return false;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }
}
