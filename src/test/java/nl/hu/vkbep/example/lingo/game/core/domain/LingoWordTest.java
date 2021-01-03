package nl.hu.vkbep.example.lingo.game.core.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LingoWordTest {
    @Test
    void validateInputWordTest(){
        LingoWord lingoWordTest = new LingoWord("zegel", "Jantje");
        String validWordRoundOne = "water";
        String invalidWordRoundOne = "wAt3!";
        assertTrue(lingoWordTest.validateInputWord(validWordRoundOne));
        assertFalse(lingoWordTest.validateInputWord(invalidWordRoundOne));
        lingoWordTest.newRound("cabine");
        String validWordRoundTwo = "waters";
        String invalidWordRoundTwo = "wAt3!s";
        assertTrue(lingoWordTest.validateInputWord(validWordRoundTwo));
        assertFalse(lingoWordTest.validateInputWord(invalidWordRoundTwo));
        lingoWordTest.newRound("aankoop");
        String validWordRoundThree = "baarden";
        String invalidWordRoundThree = "bAa!d3s";
        assertTrue(lingoWordTest.validateInputWord(validWordRoundThree));
        assertFalse(lingoWordTest.validateInputWord(invalidWordRoundThree));
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
