package org.numerals.RomanNumerals;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnJsonObjectWithInputAndOutput() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query=1234")).andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.input").value("1234"))
            .andExpect(jsonPath("$.output").value("MCCXXXIV"));
    }

    @Test
    void parameterMissing_shouldThrowBadRequest() throws Exception {
        JSONObject expected = new JSONObject();
        expected.put("error", "{\"error\":\"[Invalid Parameter Type] Method parameter 'query': Failed to convert value of type 'java.lang.String' to required type 'int'; For input string: \\\"\\\"\"}");

        this.mockMvc.perform(get("/romannumeral?query="))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    void valueOutOfRange_shouldThrowIllegalArgument_tooHigh() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query=6000"))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(
                jsonPath("$.error")
                    .value("[Invalid Parameter] Value must be an integer between 1 and 3999")
            );
    }

    @Test
    void valueOutOfRange_shouldThrowIllegalArgument_negative() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query=-1"))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(
                jsonPath("$.error")
                    .value("[Invalid Parameter] Value must be an integer between 1 and 3999")
            );
    }

    @Test
    void parameterTypeInvalid_shouldThrowMethodArgumentTypeMismatch_string() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query=asdf"))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(content().string(org.hamcrest.Matchers.containsString("[Invalid Parameter Type]")));
    }

    @Test
    void parameterTypeInvalid_shouldThrowMethodArgumentTypeMismatch_double() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query=534.1"))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(content().string(org.hamcrest.Matchers.containsString("[Invalid Parameter Type]")));
    }

    @Test
    void parameterTypeInvalid_shouldThrowMethodArgumentTypeMismatch_object() throws Exception {
        this.mockMvc.perform(get("/romannumeral?query={}"))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(content().string(org.hamcrest.Matchers.containsString("[Invalid Parameter Type]")));
    }
}
