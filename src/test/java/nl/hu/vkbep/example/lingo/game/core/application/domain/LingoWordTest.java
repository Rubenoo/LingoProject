package nl.hu.vkbep.example.lingo.game.core.application.domain;

import nl.hu.vkbep.example.lingo.game.core.domain.LingoWord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LingoWordTest {
    @Test
    void validateInputWordTest(){
        LingoWord lingoWordTest = new LingoWord("zegel", "Jantje");
        String correctWoordRondenEen = "water";
        String incorrectWoordRondenEen = "wAt3!";
        assertTrue(lingoWordTest.validateInputWord(correctWoordRondenEen));
        assertFalse(lingoWordTest.validateInputWord(incorrectWoordRondenEen));
        lingoWordTest.nieuweRonde("cabine");
        String correctWoordRondenTwee = "waters";
        String incorrectWoordRondenTwee = "wAt3!s";
        assertTrue(lingoWordTest.validateInputWord(correctWoordRondenTwee));
        assertFalse(lingoWordTest.validateInputWord(incorrectWoordRondenTwee));
        lingoWordTest.nieuweRonde("aankoop");
        String correctWoordRondenDrie = "baarden";
        String incorrectWoordRondenDrie = "bAa!d3s";
        assertTrue(lingoWordTest.validateInputWord(correctWoordRondenDrie));
        assertFalse(lingoWordTest.validateInputWord(incorrectWoordRondenDrie));
    }
    @Test
    void generateFeedbackTest(){
        LingoWord lingoWordTest = new LingoWord("zegel", "Jantje");
        lingoWordTest.play("zegel");
        List<String> actualFeedback = lingoWordTest.generateFeedback();
        List<String> expectedFeedback = List.of(
                "Correct",
                "Correct",
                "Correct",
                "Correct",
                "Correct"
        );
        assertEquals(actualFeedback,expectedFeedback);
        lingoWordTest.play("egels");
        actualFeedback = lingoWordTest.generateFeedback();
        expectedFeedback = List.of(
                "Present",
                "Present",
                "Present",
                "Present",
                "Absent"
        );
        assertEquals(actualFeedback,expectedFeedback);
    }
    @Test
    void getFirstCharacterOfWordTest(){
        LingoWord lingoWordTest = new LingoWord("zegel", "Jantje");
        Character expectedFirstCharacter = 'z';
        assertEquals(lingoWordTest.getFirstCharacterOfWord(), expectedFirstCharacter);
    }
}
