package com.example.topheadlines.dto;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
public class ArticleDTO implements Serializable {
    private String author;
    private String title;
    private String description;
    private LocalDate date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;

}
