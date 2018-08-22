package com.example.topheadlines.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class AllSources {
    private String status;
    private ArrayList<Parameter> sources;
}
