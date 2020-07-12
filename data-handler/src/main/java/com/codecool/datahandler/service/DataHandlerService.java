package com.codecool.datahandler.service;

import com.codecool.datahandler.model.Recommendation;
import com.codecool.datahandler.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class DataHandlerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${datastore.url}")
    private String baseUrl;

    public List<Video> getAllVideo(){
        System.out.println("kezd");
        ArrayList body = restTemplate.getForEntity(baseUrl + "/all", ArrayList.class).getBody();
        System.out.println("idetutinem");
        return body;
    }

    public Video getVideoById(Long id) {
        Video body = restTemplate.getForEntity(baseUrl + "/" + id,Video.class).getBody();
        return body;
    }

    public String updateVideoById(Long id,String name,String url) {
        MultiValueMap<String,String> map =new LinkedMultiValueMap<>();
        map.add("name",name);
        map.add("url",url);
        String body = restTemplate.postForEntity(baseUrl + "/update/" + id,map,String.class).getBody();
        return body;
    }
}
