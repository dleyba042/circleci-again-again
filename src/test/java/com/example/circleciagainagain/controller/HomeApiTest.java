package com.example.circleciagainagain.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeApiTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void homeTest()
    {
        //create a request for localhost
        String url = "http://localhost:" + port + "/api/v1/home";

        HttpEntity request = new HttpEntity(new HttpHeaders());
        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET,request,String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(),"Hello World");
    }
}