package com.example.topheadlines;

import com.example.topheadlines.model.Headline;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

import static com.example.topheadlines.constants.Constants.CATEGORY;
import static com.example.topheadlines.constants.Constants.COUNTRY;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadlineControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Mock
    private RestTemplate restTemplate;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(context).build();
        ObjectMapper mapper = new ObjectMapper();
        Headline headline = mapper.readValue(new File("target/test-classes/json/newsAPI.json"), Headline.class);
        when(restTemplate.getForObject(Mockito.anyString(), eq(Headline.class))).thenReturn(headline);
    }

    @Test
    public void getArticleListTest() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("countries"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(view().name("index"));
    }

    @Test
    public void getArticleTest() throws Exception {
        mockMvc
                .perform(get("/article/"+ COUNTRY +"/"+ CATEGORY+"/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("article"))
                .andExpect(view().name("modal/article :: articleContents"));
    }


}
