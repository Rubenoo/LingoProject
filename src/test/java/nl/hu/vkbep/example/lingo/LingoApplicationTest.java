package nl.hu.vkbep.example.lingo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LingoApplicationTest {
    @Test
    void does_not_explode() {
        LingoApplication.main(new String []{});
    }
}