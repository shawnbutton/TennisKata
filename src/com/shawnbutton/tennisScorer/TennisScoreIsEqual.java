package com.shawnbutton.tennisScorer;// factory methods for fluent language

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class TennisScoreIsEqual extends TypeSafeDiagnosingMatcher<TennisScore> {


// factory methods for fluent language
    static Matcher<? super TennisScore> theSameScoreAs(TennisScore tennisScore) {
        return new TennisScoreIsEqual(tennisScore);
    }


    private final Matcher<? super Integer> player1Score;
    private final Matcher<? super Integer> player2Score;


    TennisScoreIsEqual(TennisScore tennisScore) {
        player1Score = is(equalTo(tennisScore.getPlayer1Score()));
        player2Score = is(equalTo(tennisScore.getPlayer2Score()));
    }


    @Override
    protected boolean matchesSafely(TennisScore otherScore, Description mismatchDescription) {

        boolean firstMismatch = true;
        mismatchDescription.appendText("{");
        if (!player1Score.matches(otherScore.getPlayer1Score())) {
            reportMismatch("player1Score", player1Score, otherScore.getPlayer1Score(), mismatchDescription, firstMismatch);
            firstMismatch = false;
        }
        if (!player2Score.matches(otherScore.getPlayer2Score())) {
            reportMismatch("player2Score", player2Score, otherScore.getPlayer2Score(), mismatchDescription, firstMismatch);
            firstMismatch = false;
        }

        mismatchDescription.appendText("}");
        return firstMismatch;

    }


    public void describeTo(Description desc) {
        desc.appendText("{player1Score is ")
            .appendDescriptionOf(player1Score)
            .appendText(", player2Score is ")
            .appendDescriptionOf(player2Score)
            .appendText("}");
    }

static void reportMismatch(String name, Matcher<?> matcher, Object item, Description mismatchDescription, boolean firstMismatch)
{
    if (!firstMismatch)
    {
        mismatchDescription.appendText(", ");
    }
    mismatchDescription.appendText(name).appendText(" ");
    matcher.describeMismatch(item, mismatchDescription);
}


}
