package nl.hu.vkbep.example.lingo.game.core.persistence;

import nl.hu.vkbep.example.lingo.game.core.domain.Score;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class ScoreRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ScoreRepository scoreRepository;

    @Test
    public void testSave(){
        Score scoreTest = new Score("Ruben");

        List<Score> scores = (List<Score>) scoreRepository.findAll();
        int lengthBeforeSave = scores.size();
        entityManager.persist(scoreTest);
        scores = (List<Score>) scoreRepository.findAll();
        int lengthAfterSave = scores.size();
        assertEquals(lengthBeforeSave + 1,lengthAfterSave);
    }
}
