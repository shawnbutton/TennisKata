package com.shawnbutton.tennisScorer;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**

 */
public class TennisScorerTest {

    private TennisScorer scorer;

    @Before
    public void setup() {

        scorer = new TennisScorer();
    }

    @Test
    public void when_first_player_scores_point_from_0_score_goes_to_15() {
        TennisScore score = new TennisScore(0,0);
        score = scorer.getNewScore(score, PlayerEnum.PLAYER1);

        assertThat(new TennisScore(15,0), equalTo(score));

    }

    @Test
    public void when_second_player_scores_point_from_0_score_goes_to_15() {
        TennisScore score = new TennisScore(0,0);
        score = scorer.getNewScore(score, PlayerEnum.PLAYER2);

        assertThat(new TennisScore(0,15), equalTo(score));

    }

    @Test
    public void when_player_scores_point_from_0_no_winner() {
        TennisScore score = new TennisScore(0,0);
        score = scorer.getNewScore(score, PlayerEnum.PLAYER1);

        assertThat(score.isWinner(), is(false));

    }

    @Test
    public void when_player1_at_15_scores_they_have_30() {
        TennisScore score = new TennisScore(15,0);
        score = scorer.getNewScore(score, PlayerEnum.PLAYER1);

        assertThat(new TennisScore(30,0), equalTo(score));

    }

    @Test
    public void when_player2_at_15_scores_they_have_30() {
        TennisScore score = new TennisScore(15,15);
        score = scorer.getNewScore(score, PlayerEnum.PLAYER2);

        assertThat(new TennisScore(15,30), equalTo(score));

    }



}
