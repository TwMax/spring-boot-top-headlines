package com.example.topheadlines.controllers;

import com.example.topheadlines.services.RestHeadlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class WebControllerHeadlines {

    private final RestHeadlineServiceImpl service;

    @Autowired
    public WebControllerHeadlines(RestHeadlineServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView getIndex(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countries", service.getCountries());
        modelAndView.addObject("categories", service.getCategories());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/{country}/{category}")
    public ModelAndView getArticleList(Model model, @PathVariable String country,
                                                    @PathVariable String category) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("headline", service.getHeadlineService(country, category));
        modelAndView.addObject("countries", service.getCountries());
        modelAndView.addObject("categories", service.getCategories());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/article/{country}/{category}/{counter}")
    public ModelAndView getArticle(Model model, @PathVariable String country,
                                                @PathVariable String category,
                                                @PathVariable Integer counter){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article", service.getArticle(country,category,counter));
        modelAndView.setViewName("modal/article :: articleContents");
        return modelAndView;
    }

}