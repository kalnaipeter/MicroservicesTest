package com.codecool.datastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RecommendationEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String recommendation;


//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonIgnore
    @ManyToOne
    private VideoEntity videoEntity;
}
