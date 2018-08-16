package com.example.topheadlines.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Article {
    private Source source;
    private String author;
    private String title;
    private String description;
    private LocalDate publishedAt;
    private String url;
    private String urlToImage;
}
