package com.example.topheadlines;

import com.example.topheadlines.model.Headline;
import com.example.topheadlines.services.RestHeadlineServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ServicesTest {

    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    @Autowired
    private RestHeadlineServiceImpl service;


    @Test
    public void getHeadlineServiceTest() throws Exception{

        Mockito.lenient().when(restTemplate.getForObject(
                Mockito.anyString(),
                eq(Headline.class)))
                .thenReturn(null);

        assertThat(service.getHeadlineService("pl","Technology"), is(nullValue()));
    }

}

