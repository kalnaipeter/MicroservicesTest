package com.codecool.datahandler.controller;

import com.codecool.datahandler.service.DataHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataHandlerController {

    @Autowired
    private DataHandlerService dataHandlerService;

    @GetMapping("/result")
    public String result(){ return dataHandlerService.video1();}
}
