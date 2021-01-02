package nl.hu.vkbep.example.lingo.words.core.ports;

import java.util.stream.Stream;

public interface WordReader {
    Stream<String> readWords();
}
