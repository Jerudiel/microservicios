package com.unir.operadorservice.controller;

import com.unir.operadorservice.model.Order;
import com.unir.operadorservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return service.save(order);
    }
}

