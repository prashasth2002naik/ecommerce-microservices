package com.ecommerce.order.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private String status;
    public Order() { this.orderDate = LocalDateTime.now(); this.status = "COMPLETED"; }
    public Order(Double totalAmount) { this(); this.totalAmount = totalAmount; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
