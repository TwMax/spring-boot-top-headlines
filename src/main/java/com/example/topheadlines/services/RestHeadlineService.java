package com.example.topheadlines.services;

import com.example.topheadlines.model.AllSources;
import com.example.topheadlines.model.Article;
import com.example.topheadlines.model.Headline;
import com.example.topheadlines.model.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.topheadlines.consts.Consts.*;

@Service
public class RestHeadlineService {

    //define a RestTemplate object
    private final RestTemplate restTemplate;

    @Autowired
    public RestHeadlineService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Headline getHeadlineService(String country, String category){
        Headline result = restTemplate.getForObject(URL + "country=" + country + "&category=" + category +"&apiKey="+API_KEY, Headline.class);
        if (result != null) {
            result.setCategory(category);
            result.setCountry(country);
        }
        return result;
    }

    public AllSources getAllSourcesService(){
        return restTemplate.getForObject(URL_SOURCE + "&apiKey="+API_KEY, AllSources.class);
    }

    public List<Article> getAricles(String country, String category){
        return Objects.requireNonNull(restTemplate.getForObject(URL + "country=" + country + "&category=" + category + "&apiKey=" + API_KEY, Headline.class)).getArticles();
    }

    public Set<String> getCountries(){
        return Objects.requireNonNull(restTemplate.getForObject(URL_SOURCE + "&apiKey=" + API_KEY, AllSources.class)).getSources().stream()
                .map(Parameter::getCountry)
                .collect(Collectors.toSet());
    }

    public Set<String> getCategories(){
        return Objects.requireNonNull(restTemplate.getForObject(URL_SOURCE + "&apiKey=" + API_KEY, AllSources.class)).getSources().stream()
                .map(Parameter::getCategory)
                .collect(Collectors.toSet());
    }
}