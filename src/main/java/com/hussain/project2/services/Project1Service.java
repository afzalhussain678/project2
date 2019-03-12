package com.hussain.project2.services;

import com.hussain.project2.model.BaseResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Project1Service {
    private final RestTemplate restTemplate;
    public Project1Service(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate=restTemplateBuilder.build();
    }
    public BaseResponse getData(){
        return this.restTemplate.getForObject("http://localhost:8444/returnData ", BaseResponse.class);
    }
}
