package nl.hu.vkbep.example.lingo.words.infrastructure.driven.file;

import nl.hu.vkbep.example.lingo.words.core.ports.exception.CannotWriteWords;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TxtFileWordWriterTest {
    public static final Path TARGET_PATH = Path.of("src/test/resources/word-output.txt");

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(TARGET_PATH);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(TARGET_PATH);
    }

    @Test
    void write_words_to_file() throws IOException {
        var words = List.of("pizza", "bier");

        var writer = new TxtFileWordWriter(TARGET_PATH);
        writer.writeWords(words);

        var result = Files.lines(TARGET_PATH).collect(Collectors.toList());
        assertEquals(words, result);
    }

    @Test
    void cannot_write_to_non_existent_directory() {
        var words = List.of("pizza", "bier");
        var nonExistentDirectory = Path.of("src/test/resources/dir-does-not-exist/word-output.txt");

        var writer = new TxtFileWordWriter(nonExistentDirectory);

        assertThrows(CannotWriteWords.class, () -> writer.writeWords(words));
    }
}