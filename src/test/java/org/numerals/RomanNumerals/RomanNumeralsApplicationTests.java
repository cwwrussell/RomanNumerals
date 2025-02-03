package org.numerals.RomanNumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnJsonObjectWithInputAndOutput() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query=1234")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().json("{\"input\": \"1234\", \"output\": \"MCCXXXIV\"}"));
    }

    @Test
    void shouldThrowBadRequest() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query="))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldThrow() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query="))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }
}
