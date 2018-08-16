package com.example.topheadlines.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Headline {
    @JsonIgnore
    private String status;
    @JsonIgnore
    private Long totalResults;
    private String country;
    private String category;
    private ArrayList<Article> articles;

}
