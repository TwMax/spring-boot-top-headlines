package com.example.topheadlines.services;

import com.example.topheadlines.dto.AllSourcesDTO;
import com.example.topheadlines.dto.ArticleDTO;
import com.example.topheadlines.dto.HeadlineDTO;
import com.example.topheadlines.mappers.AllSourcesMapper;
import com.example.topheadlines.mappers.ArticleMapper;
import com.example.topheadlines.mappers.HeadlineMapper;
import com.example.topheadlines.model.AllSources;
import com.example.topheadlines.model.Headline;
import com.example.topheadlines.model.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.topheadlines.consts.Consts.*;

@Service
public class RestHeadlineServiceImpl implements RestHeadlineService {

    //define a RestTemplate object
    private final RestTemplate restTemplate;

    @Autowired
    public RestHeadlineServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public HeadlineDTO getHeadlineService(String country, String category){
        Headline result = restTemplate.getForObject(URL + "country=" + country + "&category=" + category +"&apiKey="+API_KEY, Headline.class);
        if (result != null) {
            result.setCategory(category);
            result.setCountry(country);
            return HeadlineMapper.map(result);
        }
        return null;
    }

    @Override
    public AllSourcesDTO getAllSourcesService(){
        return AllSourcesMapper.map(Objects.requireNonNull(restTemplate.getForObject(URL_SOURCE + "&apiKey="+API_KEY, AllSources.class)));
    }

    @Override
    public ArrayList<ArticleDTO> getArticles(String country, String category){
        return ArticleMapper.map(Objects.requireNonNull(restTemplate.getForObject(URL + "country=" + country + "&category=" + category + "&apiKey=" + API_KEY, Headline.class)).getArticles());
    }

    @Override
    public Set<String> getCountries(){
        return Objects.requireNonNull(restTemplate.getForObject(URL_SOURCE + "&apiKey=" + API_KEY, AllSources.class)).getSources().stream()
                .map(Parameter::getCountry)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getCategories(){
        return Objects.requireNonNull(restTemplate.getForObject(URL_SOURCE + "&apiKey=" + API_KEY, AllSources.class)).getSources().stream()
                .map(Parameter::getCategory)
                .collect(Collectors.toSet());
    }
}