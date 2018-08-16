package com.example.topheadlines.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ParameterDTO implements Serializable {
    private String country;
    private String category;

}
