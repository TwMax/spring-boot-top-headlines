package com.example.topheadlines.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {
    private Source source;
    private String author;
    private String title;
    private String description;
    private String publishedAt;
    private String url;
    private String urlToImage;
}
