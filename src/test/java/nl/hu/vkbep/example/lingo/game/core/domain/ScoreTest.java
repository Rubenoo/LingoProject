package nl.hu.vkbep.example.lingo.game.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class ScoreTest {
    @Test
    void turnsExceededTestHappyPath(){
        Score scoreTest = new Score();
        int numberOfValidTurns = 4;
        for (int i = 0; i < numberOfValidTurns; i++){
            scoreTest.validTurn();
        }
        assertFalse("Aantal beurten niet overschreden", scoreTest.turnsExceeded());
        scoreTest.wordQuessed();
        for (int i = 0; i < numberOfValidTurns; i++){
            scoreTest.validTurn();
        }
        assertFalse("Aantal beurten niet overschreden want ronde 1 is gehaald", scoreTest.turnsExceeded());
        scoreTest.wordQuessed();
        for (int i = 0; i < numberOfValidTurns; i++){
            scoreTest.validTurn();
        }
        assertFalse("Aantal beurten niet overschreden want ronde 1 en 2 is gehaald", scoreTest.turnsExceeded());
    }
    @Test
    void turnsExceededTestUnHappyPath(){
        Score scoreTest = new Score();
        int numberOfInvalidTurns = 5;
        for (int i = 0; i < numberOfInvalidTurns; i++){
            scoreTest.validTurn();
        }
        assertTrue("Aantal beurten overschreden", scoreTest.turnsExceeded());
        scoreTest.wordQuessed();
        for (int i = 0; i < numberOfInvalidTurns; i++){
            scoreTest.validTurn();
        }
        assertTrue("Aantal beurten overschreden want ronde 1 is gehaald", scoreTest.turnsExceeded());
        scoreTest.wordQuessed();
        for (int i = 0; i < numberOfInvalidTurns; i++){
            scoreTest.validTurn();
        }
        assertTrue("Aantal beurten overschreden want ronde 1 en 2 is gehaald", scoreTest.turnsExceeded());
    }
    @Test
    void nextRoundTest(){
        Score scoreTest = new Score();
        int lengthRoundOneActiveOrEnd = 0;
        assertEquals(scoreTest.nextRound(), lengthRoundOneActiveOrEnd);
        scoreTest.wordQuessed();
        int lengthRoundOneAchieved = 6;
        assertEquals(scoreTest.nextRound(), lengthRoundOneAchieved);
        scoreTest.wordQuessed();
        int lengthRoundTwoAchieved = 7;
        assertEquals(scoreTest.nextRound(), lengthRoundTwoAchieved);
        scoreTest.wordQuessed();
        assertEquals(scoreTest.nextRound(), lengthRoundOneActiveOrEnd);
    }

}
