package com.example.topheadlines.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class AllSourcesDTO implements Serializable {
    private ArrayList<ParameterDTO> sources;

}
