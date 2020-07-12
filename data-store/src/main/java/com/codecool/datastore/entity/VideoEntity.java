package com.codecool.datastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class VideoEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String url;

    @OneToMany(mappedBy = "videoEntity" ,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<RecommendationEntity> recommendations;
}
