package com.example.challenge4.service;

import com.example.challenge4.model.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
