package com.greenfox.resttests.controller;

import com.greenfox.resttests.model.GrootResult;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;
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

    @Test
    public void parameterIsNotPresentAndResponseIsExpected() throws Exception {

        mockMvc.perform(get("/groot"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("I am Groot!")))
                .andDo(print());
    }

    @Test
    public void happyPath() throws Exception {

        GrootResult expected = new GrootResult("somemessage");

        mockMvc.perform(get("/groot")
                .param("message", String.valueOf(expected)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("translated", is("I am Groot!")))
                .andDo(print());
    }

    @Test
    public void yonduHappyPath() throws Exception {


        mockMvc.perform(get("/yondu")
                .param("distance", "100.0")
                .param("time", "10.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.speed", is(10.0)))
                .andDo(print());
    }

    @Test
    public void yonduQueryParamIsNotPresentAndResponseIsExpected() throws Exception {

        mockMvc.perform(get("/yondu"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("Something went wrong!")))
                .andDo(print());
    }

    @Test
    public void rocketHappyPath() throws Exception {
        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".50")
                .param("amount", "5000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shipStatus", is("40%")))
                .andExpect(jsonPath("$.ready", is(false)))
                .andDo(print());
    }

    @Test
    public void emptyCargo() throws Exception {
        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".50")
                .param("amount", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shipStatus", is("empty")))
                .andExpect(jsonPath("$.ready", is(false)))
                .andDo(print());
    }

    @Test
    public void fullCargo() throws Exception {
        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".50")
                .param("amount", "12500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shipStatus", is("full")))
                .andExpect(jsonPath("$.ready", is(true)))
                .andDo(print());
    }

    @Test
    public void queryParamIsNotPresentAndResponseIsExpected() throws Exception {
        mockMvc.perform(get("/rocket/fill"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("Task failed succesfully!")))
                .andDo(print());
    }
}
