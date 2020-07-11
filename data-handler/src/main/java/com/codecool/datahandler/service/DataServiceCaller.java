package com.codecool.datahandler.service;

import com.codecool.datahandler.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class DataServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${datastore.url}")
    private String baseUrl;

    public String getvideo1(){
        Video body = restTemplate.getForEntity(baseUrl + "/1", Video.class).getBody();
        return body.getName();
    }
}