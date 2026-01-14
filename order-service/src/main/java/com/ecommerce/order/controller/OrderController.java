package com.ecommerce.order.controller;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public Order createOrder(@RequestParam Double totalAmount) { return orderService.createOrder(totalAmount); }
    @GetMapping
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }
}
