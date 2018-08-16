package com.example.topheadlines.controllers;

import com.example.topheadlines.model.AllSources;
import com.example.topheadlines.model.Headline;
import com.example.topheadlines.services.RestHeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/news")
public class ControllerHeadlinesAPI {

    //define a service constant
    private final RestHeadlineService service;

    @Autowired
    public ControllerHeadlinesAPI(RestHeadlineService service) {
        this.service = service;
    }

    @GetMapping(value = "/{country}/{category}/", produces = "application/json")
    public Headline getHeadlines(@PathVariable String country, @PathVariable String category) {
        return service.getHeadlineService(country,category);
    }

    @GetMapping("/sources")
    public AllSources getAllSources(){
        return service.getAllSourcesService();
    }
}
