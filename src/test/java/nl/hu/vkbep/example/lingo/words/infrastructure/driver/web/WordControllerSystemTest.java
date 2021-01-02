package nl.hu.vkbep.example.lingo.words.infrastructure.driver.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasLength;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("system")
@SpringBootTest
@AutoConfigureMockMvc
class WordControllerSystemTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void give_random_5_letter_word() throws Exception {
        // Run with underlying reader infrastructure
        // (uses application.properties in test resources)
        mockMvc.perform(get("/random-word")
                .param("length", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string(hasLength(5)));
    }
}