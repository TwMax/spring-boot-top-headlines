package com.example.topheadlines.mappers;

import com.example.topheadlines.dto.ArticleDTO;
import com.example.topheadlines.model.Article;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArticleMapper {

    public static ArticleDTO map(Article article) {
        return ArticleDTO.builder()
        .articleUrl(article.getUrl())
        .author(article.getAuthor())
        .date(LocalDate.parse(article.getPublishedAt(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")))
        .description(article.getDescription())
        .imageUrl(article.getUrlToImage())
        .sourceName(article.getSource().getName())
        .title(article.getTitle())
        .build();
    }

    public static ArrayList<ArticleDTO> map(ArrayList<Article> articles){
        ArrayList<ArticleDTO> articlesDTO = new ArrayList<>();
        for(Article article : articles){
            articlesDTO.add(map(article));
        }
        return articlesDTO;
    }

}
