package com.example.challenge4.service;

import com.example.challenge4.client.UserAppClient;
import com.example.challenge4.client.response.UserResponse;
import com.example.challenge4.dto.order.OrderCreateRequestDto;
import com.example.challenge4.dto.order.OrderDto;
import com.example.challenge4.model.Order;
import com.example.challenge4.model.User;
import com.example.challenge4.repository.OrderRepository;
import com.example.challenge4.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderDto create(OrderCreateRequestDto orderCreateRequestDto) {
        User user = userService.getUserById(orderCreateRequestDto.getUserResponse().getId());

        Order order = new Order();
        order.setOrderTime(LocalDate.now());
        order.setDestinationAddress(orderCreateRequestDto.getDestinationAddress());
        order.setUser(user);
        orderRepository.save(order);
        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public Order confirm(Order order) {
        order.setCompleted(true);
        return orderRepository.save(order);
    }

    @Override
    public Order getById(UUID orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.get();
    }
}
