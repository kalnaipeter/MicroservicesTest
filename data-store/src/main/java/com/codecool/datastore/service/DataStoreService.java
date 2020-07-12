package com.codecool.datastore.service;

import com.codecool.datastore.entity.VideoEntity;
import com.codecool.datastore.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DataStoreService {

    @Autowired
    private VideoRepository videoRepository;

    public List<VideoEntity> getAllVideo() {
        return videoRepository.findVideos();
    }

    public Optional<VideoEntity> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    public String updateVideoById(Long id, String name,String url) {
        videoRepository.updateById(id,name,url);
        return "Updated";
    }
}
