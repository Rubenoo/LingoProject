package nl.hu.vkbep.example.lingo.game.core.domain;

import nl.hu.vkbep.example.lingo.game.core.domain.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class ScoreTest {
    @Test
    void beurtOverschredenTestHappyPath(){
        Score scoreTest = new Score();
        int aantalRondesOmBeurtNietTeOverschrijden = 4;
        for (int i = 0; i < aantalRondesOmBeurtNietTeOverschrijden; i++){
            scoreTest.goedeBeurd();
        }
        assertFalse("Aantal beurten niet overschreden", scoreTest.beurdenOverschreden());
        scoreTest.woordGeraden();
        for (int i = 0; i < aantalRondesOmBeurtNietTeOverschrijden; i++){
            scoreTest.goedeBeurd();
        }
        assertFalse("Aantal beurten niet overschreden want ronde 1 is gehaald", scoreTest.beurdenOverschreden());
        scoreTest.woordGeraden();
        for (int i = 0; i < aantalRondesOmBeurtNietTeOverschrijden; i++){
            scoreTest.goedeBeurd();
        }
        assertFalse("Aantal beurten niet overschreden want ronde 1 en 2 is gehaald", scoreTest.beurdenOverschreden());
    }
    @Test
    void beurtOverschredenTestUnHappyPath(){
        Score scoreTest = new Score();
        int aantalRondesOmBeurtTeOverschrijden = 5;
        for (int i = 0; i < aantalRondesOmBeurtTeOverschrijden; i++){
            scoreTest.goedeBeurd();
        }
        assertTrue("Aantal beurten overschreden", scoreTest.beurdenOverschreden());
        scoreTest.woordGeraden();
        for (int i = 0; i < aantalRondesOmBeurtTeOverschrijden; i++){
            scoreTest.goedeBeurd();
        }
        assertTrue("Aantal beurten overschreden want ronde 1 is gehaald", scoreTest.beurdenOverschreden());
        scoreTest.woordGeraden();
        for (int i = 0; i < aantalRondesOmBeurtTeOverschrijden; i++){
            scoreTest.goedeBeurd();
        }
        assertTrue("Aantal beurten overschreden want ronde 1 en 2 is gehaald", scoreTest.beurdenOverschreden());
    }
    @Test
    void volgendeRondeTest(){
        Score scoreTest = new Score();
        int lengteRondeEenBezigOfEinde = 0;
        assertEquals(scoreTest.volgendeRonde(), lengteRondeEenBezigOfEinde);
        scoreTest.woordGeraden();
        int lengteRondeEenGehaald = 6;
        assertEquals(scoreTest.volgendeRonde(), lengteRondeEenGehaald);
        scoreTest.woordGeraden();
        int lengteRondeTweeGehaald = 7;
        assertEquals(scoreTest.volgendeRonde(), lengteRondeTweeGehaald);
        scoreTest.woordGeraden();
        assertEquals(scoreTest.volgendeRonde(), lengteRondeEenBezigOfEinde);
    }

}
