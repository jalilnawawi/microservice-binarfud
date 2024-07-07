package com.example.challenge4;

import com.example.challenge4.client.response.UserResponse;
import com.example.challenge4.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class BinarfudApp {

	public static void main(String[] args) {
		SpringApplication.run(BinarfudApp.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<UserResponse, User>() {
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setUsername(source.getUsername());
			}
		});
		return modelMapper;
	}

}
