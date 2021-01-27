package com.greenfox.resttests.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.resttests.model.GrootError;
import com.greenfox.resttests.model.GrootResult;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {

    @Autowired
    private MockMvc mockMvc;


        private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void parameterIsNotPresentAndResponseIsExpected() throws Exception {

        GrootError expected = new GrootError("I am Groot!");

        mockMvc.perform(get("/groot"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("I am groot!")))
                .andDo(print());
    }

    @Test
    public void happyPath() throws Exception {

        GrootResult expected = new GrootResult("somemessage");

        mockMvc.perform(get("/groot")
                .param("message", "somemessage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("translated", is("I am Groot!")))
                .andDo(print());
    }
}
