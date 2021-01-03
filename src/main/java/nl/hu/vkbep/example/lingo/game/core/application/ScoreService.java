package nl.hu.vkbep.example.lingo.game.core.application;

import nl.hu.vkbep.example.lingo.game.core.persistence.ScoreRepository;
import nl.hu.vkbep.example.lingo.game.core.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    public List<Score> getAllScores(){
        return (List<Score>) repository.findAll();
    }

    public void saveScore(Score sc){
        repository.save(sc);
    }
}
