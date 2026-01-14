package com.ecommerce.webui.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;
@FeignClient(name = "product-service")
public interface ProductClient {
@GetMapping("/products")
List<Map<String, Object>> getAllProducts(@RequestParam(required = false) String search);
}
