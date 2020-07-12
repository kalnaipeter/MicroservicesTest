package com.codecool.datahandler.controller;

import com.codecool.datahandler.model.Recommendation;
import com.codecool.datahandler.model.Video;
import com.codecool.datahandler.service.DataHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataHandlerController {

    @Autowired
    private DataHandlerService service;

    @GetMapping("/all")
    public List<Video> allVideo(){ return service.getAllVideo();}

    @GetMapping("/{id}")
    public Video videoById(@PathVariable("id")Long id){
        return service.getVideoById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateVideoById(@PathVariable("id")Long id, @RequestParam("name") String name,@RequestParam("url")String url){
        return service.updateVideoById(id,name,url);
    }
}
