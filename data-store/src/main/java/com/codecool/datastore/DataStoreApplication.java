package com.codecool.datastore;

import com.codecool.datastore.entity.RecommendationEntity;
import com.codecool.datastore.entity.VideoEntity;
import com.codecool.datastore.repository.RecommendationRepository;
import com.codecool.datastore.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class DataStoreApplication {

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private RecommendationRepository recommendationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DataStoreApplication.class, args);
	}

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
//	@Profile("production")
	public CommandLineRunner init(){
		return args -> {

			RecommendationEntity recommendationEntity1 = RecommendationEntity.builder()
					.recommendation("does not worth the time, such a fleo movie")
					.build();

			RecommendationEntity recommendationEntity2 = RecommendationEntity.builder()
					.recommendation("nice strategy, its a TODO for me to try beat the legend rank with it")
					.build();

			RecommendationEntity recommendationEntity3 = RecommendationEntity.builder()
					.recommendation("recommendation not available yet...")
					.build();

			RecommendationEntity recommendationEntity4 = RecommendationEntity.builder()
					.recommendation("5/10")
					.build();

			VideoEntity video1 = VideoEntity.builder()
					.name("Crawl")
					.url("https://www.youtube.com/watch?v=H6MLJG0RdDE")
					.recommendation(recommendationEntity1)
					.build();

			VideoEntity video2 = VideoEntity.builder()
					.name("Highkeeper Ra 40 dmg OTK Combo")
					.url("https://www.youtube.com/watch?v=Tom4XAUoeZ0")
					.recommendation(recommendationEntity2)
					.build();

			VideoEntity video3 = VideoEntity.builder()
					.name("47 Meters Down: Uncaged ")
					.url("https://www.youtube.com/watch?v=AvXjx8SZbv8")
					.recommendation(recommendationEntity3)
					.build();

			VideoEntity video4 = VideoEntity.builder()
					.name("Yung Lean — Outta My Head")
					.url("https://www.youtube.com/watch?v=2Kjy5r6wS6w")
					.recommendation(recommendationEntity4)
					.build();

			recommendationEntity2.setVideoEntity(video2);
			recommendationEntity1.setVideoEntity(video1);
			recommendationEntity3.setVideoEntity(video3);
			recommendationEntity4.setVideoEntity(video4);

			videoRepository.save(video2);
			videoRepository.save(video3);
			videoRepository.save(video4);
			videoRepository.save(video1);

		};
	}
}
