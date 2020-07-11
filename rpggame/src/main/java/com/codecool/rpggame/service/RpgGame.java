package com.codecool.rpggame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RpgGame {

    @Autowired
    private RollServiceCaller rollServiceCaller;

    public String video1(){
        return "result = " + rollServiceCaller.getvideo1();
    }

}
