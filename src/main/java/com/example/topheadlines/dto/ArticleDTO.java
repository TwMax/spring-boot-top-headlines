package com.example.topheadlines.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
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
