package com.example.topheadlines.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class HeadlineDTO implements Serializable {
    private String country;
    private String category;
    private ArrayList<ArticleDTO> articles;
}
