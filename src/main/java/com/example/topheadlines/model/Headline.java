package com.example.topheadlines.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Headline {
    private String status;
    private Long totalResults;
    private ArrayList<Article> articles;

}
