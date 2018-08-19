package com.example.topheadlines.controllers;

import com.example.topheadlines.services.RestHeadlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class WebControllerHeadlines {

    private final RestHeadlineServiceImpl service;

    @Autowired
    public WebControllerHeadlines(RestHeadlineServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public String getArticleList(Model model, @RequestParam(defaultValue = "") String country,
                                 @RequestParam(defaultValue = "") String category) {

        if (!country.equals("") && !category.equals("")) model.addAttribute("headline", service.getHeadlineService(country, category));
        model.addAttribute("countries", service.getCountries());
        model.addAttribute("categories", service.getCategories());
        return "index";
    }

    @GetMapping("/headline/{counter}")
    public String getHeadline(Model model, @PathVariable Integer counter,
                                 @RequestParam(defaultValue = "pl") String country,
                                 @RequestParam(defaultValue = "technology") String category) {
        model.addAttribute("headline", service.getArticles(country, category).get(counter));
        return "modal/headline :: headlineContents";
    }

}