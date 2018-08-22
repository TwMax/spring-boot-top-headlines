package com.example.topheadlines.controllers;

import com.example.topheadlines.dto.AllSourcesDTO;
import com.example.topheadlines.dto.HeadlineDTO;
import com.example.topheadlines.services.RestHeadlineService;
import com.example.topheadlines.services.RestHeadlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/news")
public class APIControllerHeadlines {

    //define a service constant
    private final RestHeadlineService service;

    @Autowired
    public APIControllerHeadlines(RestHeadlineServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/{country}/{category}/", produces = "application/json")
    public HeadlineDTO getHeadlines(@PathVariable String country,
                                    @PathVariable String category) {
        return service.getHeadlineService(country,category);
    }

    @GetMapping("/sources")
    public AllSourcesDTO getAllSources(){
        return service.getAllSourcesService();
    }
}
