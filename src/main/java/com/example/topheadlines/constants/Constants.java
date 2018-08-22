package com.example.topheadlines.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    @Value("${api_key}")
    public void setApiKey(String apiKey) {
        API_KEY = apiKey;
    }

    public static String API_KEY;
    public final static String URL = "https://newsapi.org/v2/top-headlines?";
    public final static String URL_SOURCE = "https://newsapi.org/v2/sources?";
    public static final String COUNTRY = "pl";
    public static final String CATEGORY = "technology";
}
