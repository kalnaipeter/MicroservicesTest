package com.codecool.datahandler.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataHandlerService {

    @Autowired
    private DataServiceCaller dataServiceCaller;

    public String video1(){
        return "result = " + dataServiceCaller.getvideo1();
    }

}
