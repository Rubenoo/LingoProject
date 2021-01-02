package nl.hu.vkbep.example.lingo.words.infrastructure.driver.web;

import nl.hu.vkbep.example.lingo.words.core.ports.WordReader;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasLength;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("integration")
@SpringBootTest
@AutoConfigureMockMvc
class WordControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("random-word")
    private WordReader reader;

    @Test
    void give_random_5_letter_word() throws Exception {
        // Run without underlying reader infrastructure
        Mockito.when(reader.readWords()).thenReturn(
                Stream.of("google", "koala", "bier")
        );

        mockMvc.perform(get("/random-word")
                .param("length", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string(hasLength(5)));
    }
}