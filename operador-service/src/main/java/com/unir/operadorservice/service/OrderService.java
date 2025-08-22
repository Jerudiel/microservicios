package com.unir.operadorservice.service;

import com.unir.operadorservice.model.Order;
import com.unir.operadorservice.model.Product;
import com.unir.operadorservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final RestTemplate restTemplate;

    /*public OrderService(OrderRepository repository) {
        this.repository = repository;
    }*/
    public OrderService(OrderRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }


    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order save(Order order) {
        //return repository.save(order);
        Product product = restTemplate.getForObject(
        "http://buscador-service/products/" + order.getProductId(),
        Product.class
        );

        if (product == null || product.getStock() < order.getQuantity()) {
            throw new RuntimeException("Producto no disponible o stock insuficiente");
        }

        return repository.save(order);

    }
}
