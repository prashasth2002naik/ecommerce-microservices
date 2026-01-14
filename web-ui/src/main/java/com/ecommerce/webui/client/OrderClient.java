package com.ecommerce.webui.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
@FeignClient(name = "order-service")
public interface OrderClient {
@PostMapping("/orders")
Map<String, Object> createOrder(@RequestParam Double totalAmount);
}
