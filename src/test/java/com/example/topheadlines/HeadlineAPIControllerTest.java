package com.example.topheadlines;

import com.example.topheadlines.model.AllSources;
import com.example.topheadlines.model.Headline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadlineAPIControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    private RestTemplate restTemplate;
    private static final String COUNTRY = "pl";
    private static final String CATEGORY = "technology";
    @Before
    public void setup() throws Exception {
        mockMvc = webAppContextSetup(context).build();
        this.restTemplate = new RestTemplate(new MockMvcClientHttpRequestFactory(mockMvc));

    }

    @Test
    public void retrieveSources() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/news/sources")).andExpect(status().isOk());
        AllSources result = this.restTemplate.getForObject("/news/sources", AllSources.class);
        assertEquals("us", Objects.requireNonNull(result).getSources().get(0).getCountry());
        assertEquals("general", Objects.requireNonNull(result).getSources().get(0).getCategory());
    }

    @Test
    public void retrieveHeadline() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/news/{country}/{category}/",COUNTRY,CATEGORY)).andExpect(status().isOk());
        Headline result = this.restTemplate.getForObject("/news/"+COUNTRY+"/"+CATEGORY+"/", Headline.class);
        assertEquals(COUNTRY, Objects.requireNonNull(result).getCountry());
        assertEquals(CATEGORY, Objects.requireNonNull(result).getCategory());
    }
}
