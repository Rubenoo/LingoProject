package nl.hu.vkbep.example.lingo.game.core.presentation;

import nl.hu.vkbep.example.lingo.game.core.application.LingoService;
import nl.hu.vkbep.example.lingo.game.core.application.ScoreService;
import nl.hu.vkbep.example.lingo.words.core.application.WordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lingo")
public class LingoController {
    private final WordService wordService;
    private final LingoService lingoService;
    private final ScoreService scoreService;

    public LingoController(WordService wordService, LingoService lingoService, ScoreService scoreService) {
        this.wordService = wordService;
        this.lingoService = lingoService;
        this.scoreService = scoreService;
    }

    @GetMapping("/start")
    public String startGame(@RequestParam String name) {
        return lingoService.createGame(name, this.wordService.getRandomWord(5));
    }

    @GetMapping("/play")
    public String play(@RequestParam int key, @RequestParam String word) {
        if (!lingoService.authenticate(key)){
           return "Key komt niet overeen!";
        }else if(lingoService.nextRound() != 0){
            return lingoService.newRound(this.wordService.getRandomWord(lingoService.nextRound()));
        }else if (!wordService.validWord(word)){
            lingoService.InvalidTurn();
            return "Geen geldig woord gegeven!";
        }
        return lingoService.play(word);
    }

    @GetMapping("/save")
    public String saveCurrentGame(@RequestParam int key) {
        if(lingoService.currentGameActive())
            if (!lingoService.authenticate(key)) {
                return "Key komt niet overeen!";
            }else{
                scoreService.saveScore(lingoService.getScore());
                lingoService.clearCurrentGame();
                return "Spel opgeslagen!";
            }
        else{
            return "Er is geen actief spel die opgeslagen kan worden!";
        }
    }

    @GetMapping("/scores")
    public String allScores(){
        return "Alle scores: \n" + scoreService.getStringAllScores();
    }
}
