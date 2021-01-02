package nl.hu.vkbep.example.lingo.words.infrastructure.driver.web;

import nl.hu.vkbep.example.lingo.words.core.application.WordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random-word")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public String getRandomWord(@RequestParam int length) {
        return this.wordService.getRandomWord(length);
    }
}
