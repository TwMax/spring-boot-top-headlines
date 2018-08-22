package com.example.topheadlines.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parameter {
    private String id;
    private String name;
    private String description;
    private String url;
    private String country;
    private String language;
    private String category;
}
