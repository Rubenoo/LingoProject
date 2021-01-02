package nl.hu.vkbep.example.lingo.game.core.application.domain;

import nl.hu.vkbep.example.lingo.game.core.domain.Score;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class ScoreTest {
    @Test
    public void beurtOverschredenTest(){
        Score scoreTest = new Score();
        int aantalRondesOmBeurtNietTeOverschrijden = 4;
        int aantalRondesOmBeurtTeOverschrijden = 5;
        for (int i = 0; i < aantalRondesOmBeurtNietTeOverschrijden; i++){
            scoreTest.ongeldigeBeurd();
        }
        assertFalse("Aantal beurten niet overschreden", scoreTest.beurdenOverschreden());
        scoreTest.goedeBeurd();
        assertTrue("Aantal beurten overschreden", scoreTest.beurdenOverschreden());
        scoreTest.woordGeraden();
        assertFalse("Aantal beurten niet overschreden want ronde 1 is gehaald", scoreTest.beurdenOverschreden());
        for (int i = 0; i < aantalRondesOmBeurtTeOverschrijden; i++){
            scoreTest.ongeldigeBeurd();
        }
        assertTrue("Aantal beurten overschreden ook al is ronden 1 gehaald", scoreTest.beurdenOverschreden());
    }
}
