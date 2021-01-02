package nl.hu.vkbep.example.lingo.words.infrastructure.driven.file;

import lombok.extern.slf4j.Slf4j;
import nl.hu.vkbep.example.lingo.words.core.ports.WordWriter;
import nl.hu.vkbep.example.lingo.words.core.ports.exception.CannotWriteWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class TxtFileWordWriter implements WordWriter {
    private final Path target;

    public TxtFileWordWriter(Path target) {
        this.target = target;
    }

    @Override
    public void writeWords(List<String> words) {
        try {
            log.info("Writing words to file {}", this.target);
            Files.writeString(target, String.join("\n", words));
        } catch (IOException e) {
            throw CannotWriteWords.because(e);
        }
    }
}
