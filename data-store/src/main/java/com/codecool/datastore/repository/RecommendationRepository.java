package com.codecool.datastore.repository;

import com.codecool.datastore.entity.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<RecommendationEntity,Long> {
}
