package com.example.topheadlines.mappers;

import com.example.topheadlines.dto.HeadlineDTO;
import com.example.topheadlines.model.Headline;


public class HeadlineMapper {
    public static HeadlineDTO map(Headline headline, String country, String category){
        HeadlineDTO headlineDTO = new HeadlineDTO();
        headlineDTO.setCategory(category);
        headlineDTO.setCountry(country);
        headlineDTO.setArticles(ArticleMapper.map(headline.getArticles()));
        return headlineDTO;
    }
}
