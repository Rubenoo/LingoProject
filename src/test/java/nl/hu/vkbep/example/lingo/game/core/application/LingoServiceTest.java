package nl.hu.vkbep.example.lingo.game.core.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LingoServiceTest {
    @Test
    void currentGameActiveTest(){
        LingoService lingoService = new LingoService();

        assertFalse(lingoService.currentGameActive());//No game active

        lingoService.createGame("Jantje", "zegel");
        assertTrue(lingoService.currentGameActive());// One game active

        lingoService.clearCurrentGame();
        assertFalse(lingoService.currentGameActive());//No game active because active game got cleared
    }
}
