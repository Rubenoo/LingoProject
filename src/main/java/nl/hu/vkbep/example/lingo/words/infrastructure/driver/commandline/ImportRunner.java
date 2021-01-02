package nl.hu.vkbep.example.lingo.words.infrastructure.driver.commandline;

import lombok.extern.slf4j.Slf4j;
import nl.hu.vkbep.example.lingo.words.core.application.WordImporter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ImportRunner implements CommandLineRunner {
    private final WordImporter wordImporter;

    public ImportRunner(WordImporter wordImporter) {
        this.wordImporter = wordImporter;
    }

    @Override
    public void run(String... args) {
        log.info("Starting import");
        wordImporter.importWords();
        log.info("Import finished");
    }
}
