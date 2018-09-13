package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloTest1() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DemoApplication.User user = new DemoApplication.User();
        user.setId(1);
        user.setName("Me");
        this.mockMvc.perform(post("/hello").content(mapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void helloTest2() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DemoApplication.User user = new DemoApplication.User();
        user.setId(1);
        user.setNames(Arrays.asList("me", "you"));
        this.mockMvc.perform(post("/hello").content(mapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}