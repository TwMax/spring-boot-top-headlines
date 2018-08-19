package com.example.topheadlines;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadlineControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void getArticleList() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("countries"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(view().name("index"));
    }

    @Test
    public void getHeadline() throws Exception {
        mockMvc
                .perform(get("/headline/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("headline"))
                .andExpect(view().name("modal/headline :: headlineContents"));
    }

}
