package com.sapient.benchmark.event;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestgetHtml {

	  private RestTemplate restTemplate = new RestTemplate();
	
	public String getHtml() throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("content-type", "text/html; charset=UTF-8");
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		requestEntity.getHeaders();
		ResponseEntity<String> html = restTemplate.exchange("https://www.google.co.in/", HttpMethod.GET, requestEntity, String.class);
		return(html.getBody());
	}
}
