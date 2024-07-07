package com.example.challenge4.dto.order;

import com.example.challenge4.client.response.UserResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderCreateRequestDto {
    private LocalDate orderTime;

    private String destinationAddress;

    private UserResponse userResponse;

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
