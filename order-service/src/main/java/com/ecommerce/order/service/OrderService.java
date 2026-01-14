package com.ecommerce.order.service;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order createOrder(Double totalAmount) {
        return orderRepository.save(new Order(totalAmount));
    }
    public List<Order> getAllOrders() { return orderRepository.findAll(); }
}
