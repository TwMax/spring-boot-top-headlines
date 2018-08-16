package com.example.topheadlines;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.net.UnknownHostException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTopHeadlinesApplicationTests {

	@Test
	public void getAllSourceRestService() throws UnknownHostException, IOException {
		// Given
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet( "https://newsapi.org/v2/sources?&apiKey=d8033a63842e433d9c799c85625e6e2b");

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute( request );

		// Then
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals( jsonMimeType, mimeType );
		assertThat(response.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));
	}

	@Test
	public void getAllHeadlineRestService() throws UnknownHostException, IOException {
		// Given
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet( "https://newsapi.org/v2/top-headlines?country=pl&category=technology&apiKey=d8033a63842e433d9c799c85625e6e2b");

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute( request );

		// Then
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals( jsonMimeType, mimeType );
		assertThat(response.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));

	}
}
