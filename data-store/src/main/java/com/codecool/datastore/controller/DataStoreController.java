package com.codecool.datastore.controller;

import com.codecool.datastore.entity.VideoEntity;
import com.codecool.datastore.service.DataStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/video")
public class DataStoreController {

    @Autowired
    private DataStoreService service;

    @GetMapping("/all")
    public List<VideoEntity> allVideos(){
        System.out.println("ideiseljut");
        return service.getAllVideo();
    }

    @GetMapping("/{id}")
    public Optional<VideoEntity> getEntityById(@PathVariable("id")Long id){
        return service.getVideoById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateVideo(@PathVariable("id")Long id, @RequestBody MultiValueMap<String,String> map){
        return service.updateVideoById(id,map.getFirst("name"),map.getFirst("url"));
    }
}
