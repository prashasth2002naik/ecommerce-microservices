package com.ecommerce.webui.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@FeignClient(name = "cart-service")
public interface CartClient {
@PostMapping("/cart/add")
void addToCart(@RequestParam Long productId, @RequestParam Integer quantity);
@GetMapping("/cart/summary")
Map<String, Object> getCartSummary();
@PostMapping("/cart/remove")
void removeFromCart(@RequestParam Long productId);
@PostMapping("/cart/update")
void updateQuantity(@RequestParam Long productId, @RequestParam Integer quantity);
@PostMapping("/cart/clear")
void clearCart();
}
