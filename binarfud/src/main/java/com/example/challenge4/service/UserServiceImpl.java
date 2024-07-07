package com.example.challenge4.service;

import com.example.challenge4.client.UserAppClient;
import com.example.challenge4.client.response.UserResponse;
import com.example.challenge4.model.User;
import com.example.challenge4.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAppClient userAppClient;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User getUserById(UUID id) {
        ResponseEntity<UserResponse> userResponseEntity = userAppClient.getUserById(id);
        UserResponse userResponse = userResponseEntity.getBody();

        User user = modelMapper.map(userResponse, User.class);
        return userRepository.save(user);
    }
}
