package com.example.topheadlines.mappers;

import com.example.topheadlines.dto.HeadlineDTO;
import com.example.topheadlines.model.Headline;


public class HeadlineMapper {
    public static HeadlineDTO map(Headline headline){
        HeadlineDTO headlineDTO = new HeadlineDTO();
        headlineDTO.setCategory(headline.getCategory());
        headlineDTO.setCountry(headline.getCountry());
        headlineDTO.setArticles(ArticleMapper.map(headline.getArticles()));
        return headlineDTO;
    }
}
