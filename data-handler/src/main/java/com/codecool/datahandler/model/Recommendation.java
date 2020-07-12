package com.codecool.datahandler.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Recommendation {
    private Long id;
    private String recommendation;
    private Video video;
}
