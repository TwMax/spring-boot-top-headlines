package com.example.topheadlines;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.example.topheadlines.constants.Constants;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadlineAPIControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() throws Exception {
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void retrieveSources() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/news/sources"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sources[0].country").value("us"))
                .andExpect(jsonPath("$.sources[0].category").value("general"));
    }

    @Test
    public void retrieveHeadline() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/news/{country}/{category}/", Constants.COUNTRY, Constants.CATEGORY))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value(Constants.COUNTRY))
                .andExpect(jsonPath("$.category").value(Constants.CATEGORY));
    }
}
