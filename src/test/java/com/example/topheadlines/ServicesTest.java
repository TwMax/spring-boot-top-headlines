package com.example.topheadlines;

import com.example.topheadlines.dto.AllSourcesDTO;
import com.example.topheadlines.dto.ArticleDTO;
import com.example.topheadlines.dto.HeadlineDTO;
import com.example.topheadlines.model.AllSources;
import com.example.topheadlines.model.Headline;
import com.example.topheadlines.services.RestHeadlineServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Set;

import static com.example.topheadlines.constants.Constants.CATEGORY;
import static com.example.topheadlines.constants.Constants.COUNTRY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ServicesTest {

    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    @Autowired
    private RestHeadlineServiceImpl service;

    @Before
    public void setUp() throws Exception {
        Headline headline = new ObjectMapper().readValue(new File("target/test-classes/json/newsAPI.json"), Headline.class);
        when(restTemplate.getForObject(Mockito.anyString(), eq(Headline.class))).thenReturn(headline);

        AllSources sources = new ObjectMapper().readValue(new File("target/test-classes/json/sources.json"), AllSources.class);
        when(restTemplate.getForObject(Mockito.anyString(), eq(AllSources.class))).thenReturn(sources);

    }

    @Test
    public void getHeadlineNULLServiceTest() throws Exception{
        when(restTemplate.getForObject(Mockito.anyString(), eq(Headline.class))).thenReturn(null);
        assertThat(service.getHeadlineService("pl","Technology")).isNull();

    }

    @Test
    public void getHeadlineServiceTest() throws Exception{
        HeadlineDTO headlineDTO = service.getHeadlineService(COUNTRY,CATEGORY);
        assertThat(headlineDTO.getCountry()).isEqualTo(COUNTRY);
        assertThat(headlineDTO.getCategory()).isEqualTo(CATEGORY);
    }

    @Test
    public void getAllSourcesServiceTest() throws Exception{
        AllSourcesDTO allSourcesDTO = service.getAllSourcesService();
        assertThat(allSourcesDTO.getSources().get(0).getCountry()).isEqualTo("us");
        assertThat(allSourcesDTO.getSources().get(0).getCategory()).isEqualTo("general");
    }

    @Test
    public void getArticleTest() throws Exception{
        ArticleDTO articleDTO = service.getArticle(COUNTRY,CATEGORY,1);
        assertThat(articleDTO.getAuthor()).isEqualTo("Damian Kwiek");
        assertThat(articleDTO.getTitle()).isEqualTo("Huawei Mate 20 Lite przedpremierowo w ofercie Plusa");
    }

    @Test
    public void getCountriesTest() throws Exception{
        Set<String> countries = service.getCountries();
        assertThat(countries).contains("us");
    }

    @Test
    public void getCategoriesTest() throws Exception{
        Set<String> categories = service.getCategories();
        assertThat(categories).contains("business");
    }
}

