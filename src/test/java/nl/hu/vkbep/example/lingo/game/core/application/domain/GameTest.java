package nl.hu.vkbep.example.lingo.game.core.application.domain;

import nl.hu.vkbep.example.lingo.game.core.domain.Game;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {
    @Test
    void authenticateTest(){
        Game gameTest = new Game("Jantje", "zegel");
        int correctKey = gameTest.getIntKey();
        int incorrectKey = 1;
        assertTrue("De correcte key word gebruikt", gameTest.authenticate(correctKey));
        assertFalse("De incorrecte key word gebruikt", gameTest.authenticate(incorrectKey));
    }
}
