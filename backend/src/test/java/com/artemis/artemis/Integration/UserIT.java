package com.artemis.artemis.Integration;

import com.artemis.artemis.models.User;
import com.artemis.artemis.repos.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.Access;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application-it.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    public void setup() {
        User testUser = new User();
        testUser.setUsername("Apollo");
        userRepo.save(testUser);
    }

    @Test
    public void getUsers_ReturnUsers_Success() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/users");

        ResultActions resultActions = mockMvc.perform(request);

        MvcResult result = resultActions
                .andExpect(status().isOk())
                // ! jsonPath lets you query json data.
                // ! The $ symbol starts from the top of our json response.
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].username").value("Apollo"))
                //.andExpect(jsonPath("$[1].id").value(2))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }



}
