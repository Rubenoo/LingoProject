package nl.hu.vkbep.example.lingo.words.infrastructure.driver.commandline;

import nl.hu.vkbep.example.lingo.words.core.application.WordImporter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ImportRunnerTest {
    @Test
    void call_import_words_when_running() {
        var mockImporter = mock(WordImporter.class);

        var runner = new ImportRunner(mockImporter);
        runner.run();

        verify(mockImporter, times(1)).importWords();
    }
}