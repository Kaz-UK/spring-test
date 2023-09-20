package com.sky.practice.dogs.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.practice.dogs.domain.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql (scripts = {"classpath:dog-schema.sql", "classpath:dog-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DogIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void testCreate1() throws Exception {

        Dog testDog = new Dog(null, "Louie", "Border Terrier", 5);
        String expectedBody = this.mapper.writeValueAsString(testDog);

        RequestBuilder req = MockMvcRequestBuilders.post("/create").content(expectedBody).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        testDog.setId(2);
        String resultBody = this.mapper.writeValueAsString(testDog);
        ResultMatcher checkResultBody = MockMvcResultMatchers.content().json(resultBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkResultBody);

    }

    @Test
    void testRead() throws Exception {

        String resultBody = this.mapper.writeValueAsString(new Dog(1, "Louie", "Border Terrier", 6));

        this.mvc.perform(MockMvcRequestBuilders.get("/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resultBody));

    }

    @Test
    void testUpdate() throws Exception {

        String resultBody = this.mapper.writeValueAsString(new Dog(1, "Fred", "Border Terrier", 6));

        this.mvc.perform(MockMvcRequestBuilders.patch("/update?id=1&name=Fred"))
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().json(resultBody));

    }

    @Test
    void testDelete() throws Exception {

        String result = "This dog has been removed from the database";

        this.mvc.perform(MockMvcRequestBuilders.delete("/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string(result));
    }

}
