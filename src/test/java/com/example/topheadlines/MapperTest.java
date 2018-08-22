package com.example.topheadlines;

import com.example.topheadlines.dto.AllSourcesDTO;
import com.example.topheadlines.dto.ArticleDTO;
import com.example.topheadlines.dto.HeadlineDTO;
import com.example.topheadlines.dto.ParameterDTO;
import com.example.topheadlines.mappers.AllSourcesMapper;
import com.example.topheadlines.mappers.ArticleMapper;
import com.example.topheadlines.mappers.HeadlineMapper;
import com.example.topheadlines.mappers.ParameterMapper;
import com.example.topheadlines.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    private Article article;
    private Headline headline;
    private Parameter parameter;
    private AllSources allSources;

    @Before
    public void setUp() throws Exception {
        article = new Article();
        article.setUrl("articleUrl");
        article.setAuthor("author");
        article.setPublishedAt("2018-08-19T20:16:45Z");
        article.setDescription("description");
        article.setUrlToImage("imageUrl");
        Source source = new Source();
        source.setId("1");
        source.setName("sourceName");
        article.setSource(source);
        article.setTitle("title");

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article);
        headline = new Headline();
        headline.setStatus("status");
        headline.setTotalResults(1L);
        headline.setArticles(articles);

        parameter = new Parameter();
        parameter.setCategory("category");
        parameter.setCountry("country");

        ArrayList<Parameter> parameters = new ArrayList<>();
        allSources = new AllSources();
        parameters.add(parameter);
        allSources.setSources(parameters);
    }

    @Test
    public void articleMapperTest() throws Exception{
        ArticleDTO articleMapDTO = ArticleMapper.map(article);
        assertThat(articleMapDTO.getArticleUrl()).isEqualTo("articleUrl");
        assertThat(articleMapDTO.getAuthor()).isEqualTo("author");
        assertThat(articleMapDTO.getDate()).isEqualTo(LocalDate.of(2018, 8, 19));
        assertThat(articleMapDTO.getDescription()).isEqualTo("description");
        assertThat(articleMapDTO.getImageUrl()).isEqualTo("imageUrl");
        assertThat(articleMapDTO.getSourceName()).isEqualTo("sourceName");
        assertThat(articleMapDTO.getTitle()).isEqualTo("title");
    }

    @Test
    public void headlineMapperTest() throws Exception{
        HeadlineDTO headlineMapDTO = HeadlineMapper.map(headline,"country","category");
        assertThat(headlineMapDTO.getCountry()).isEqualTo("country");
        assertThat(headlineMapDTO.getCategory()).isEqualTo("category");
        assertThat(headlineMapDTO.getArticles().get(0).getTitle()).isEqualTo("title");
        assertThat(headlineMapDTO.getArticles().get(0).getSourceName()).isEqualTo("sourceName");
        assertThat(headlineMapDTO.getArticles().get(0).getImageUrl()).isEqualTo("imageUrl");
        assertThat(headlineMapDTO.getArticles().get(0).getDescription()).isEqualTo("description");
        assertThat(headlineMapDTO.getArticles().get(0).getDate()).isEqualTo(LocalDate.of(2018, 8, 19));
        assertThat(headlineMapDTO.getArticles().get(0).getAuthor()).isEqualTo("author");
        assertThat(headlineMapDTO.getArticles().get(0).getArticleUrl()).isEqualTo("articleUrl");
    }

    @Test
    public void allSourcesMapperTest() throws Exception{
        AllSourcesDTO allSourcesDTO = AllSourcesMapper.map(allSources);
        assertThat(allSourcesDTO.getSources().get(0).getCountry()).isEqualTo("country");
        assertThat(allSourcesDTO.getSources().get(0).getCategory()).isEqualTo("category");
    }

    @Test
    public void parameterMapperTest() throws Exception{
        ParameterDTO parameterDTO = ParameterMapper.map(parameter);
        assertThat(parameterDTO.getCountry()).isEqualTo("country");
        assertThat(parameterDTO.getCategory()).isEqualTo("category");
    }
}
