package com.codecool.datastore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoEntity{
    private int id;
    private String name;
    private String url;
}
