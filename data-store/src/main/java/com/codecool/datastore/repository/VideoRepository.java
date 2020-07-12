package com.codecool.datastore.repository;

import com.codecool.datastore.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<VideoEntity,Long> {

    @Query("SELECT v FROM VideoEntity v")
    List<VideoEntity> findVideos();

    Optional<VideoEntity> findById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE VideoEntity v set v.name = :name ,v.url = :url WHERE v.id = :id")
    void updateById(@Param("id")Long id,@Param("name")String name,@Param("url")String url);
}
