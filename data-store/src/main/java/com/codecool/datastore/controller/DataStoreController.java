package com.codecool.datastore.controller;

import com.codecool.datastore.entity.VideoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/video")
public class DataStoreController {

    @GetMapping("/1")
    public VideoEntity video1(){
        return new VideoEntity(
                1,
                "video1",
                "www.video1.com"
        );
    }
}
