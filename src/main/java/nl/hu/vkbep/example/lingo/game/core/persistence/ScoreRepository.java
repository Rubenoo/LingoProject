package nl.hu.vkbep.example.lingo.game.core.persistence;

import nl.hu.vkbep.example.lingo.game.core.domain.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
}
