package com.example.challenge4.client;

import com.example.challenge4.client.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "user-app")
public interface UserAppClient {
    @GetMapping("user/{id}")
    ResponseEntity<UserResponse> getUserById(@PathVariable("id")UUID userId);
}
