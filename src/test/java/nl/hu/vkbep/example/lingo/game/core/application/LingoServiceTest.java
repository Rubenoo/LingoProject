package nl.hu.vkbep.example.lingo.game.core.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LingoServiceTest {
    @Test
    void currentGameActiveTest(){
        LingoService lingoService = new LingoService();

        assertFalse(lingoService.currentGameActive());//Er is nog geen game actief

        lingoService.createGame("Jantje", "zegel");
        assertTrue(lingoService.currentGameActive());// Nu is er wel een game actief

        lingoService.clearCurrentGame();
        assertFalse(lingoService.currentGameActive());//Er is nog geen game actief want hij is net geleegd
    }
}
