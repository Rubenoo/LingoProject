package nl.hu.vkbep.example.lingo.words.core.application;

import nl.hu.vkbep.example.lingo.words.core.ports.WordReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class WordServiceTest {
    @Test
    void get_random_word() {
        List<String> readWords = List.of(
                "bieren",
                "pizza",
                "koala",
                "baard"
        );
        int index = 1;
        String expected = "koala";

        var random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(index);

        var reader = mock(WordReader.class);
        when(reader.readWords()).thenReturn(readWords.stream());

        var service = new WordService(random, reader);

        String word = service.getRandomWord(5);

        assertEquals(expected, word);
    }

    @Test
    void word_length_cannot_be_smaller_than_5() {
        var random = mock(Random.class);
        var reader = mock(WordReader.class);
        var service = new WordService(random, reader);

        Executable shouldFail = () -> service.getRandomWord(4);
        assertThrows(RuntimeException.class, shouldFail);
    }

    @Test
    void word_length_cannot_be_larger_than_7() {
        var random = mock(Random.class);
        var reader = mock(WordReader.class);
        var service = new WordService(random, reader);

        Executable shouldFail = () -> service.getRandomWord(8);
        assertThrows(RuntimeException.class, shouldFail);
    }
}