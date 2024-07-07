package com.example.challenge4.dto.order;

import com.example.challenge4.client.response.UserResponse;
import com.example.challenge4.model.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID id;

    private LocalDate orderTime;

    private String destinationAddress;

    private User user;

    private boolean completed;
    private boolean deleted;
}
