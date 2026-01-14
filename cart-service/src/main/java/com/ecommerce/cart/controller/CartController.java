package com.ecommerce.cart.controller;
import com.ecommerce.cart.model.CartItem;
import com.ecommerce.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/add")
    public void addToCart(@RequestParam Long productId, @RequestParam Integer quantity) {
        cartService.addToCart(productId, quantity);
    }
    @GetMapping
    public List<CartItem> getCart() { return cartService.getCartItems(); }
    @GetMapping("/summary")
    public Map<String, Object> getCartSummary() {
        return Map.of("items", cartService.getCartItems(), "total", cartService.getTotal(), "size", cartService.getCartSize());
    }
    @PostMapping("/remove")
    public void removeFromCart(@RequestParam Long productId) { cartService.removeFromCart(productId); }
    @PostMapping("/update")
    public void updateQuantity(@RequestParam Long productId, @RequestParam Integer quantity) {
        if (quantity <= 0) cartService.removeFromCart(productId);
        else cartService.updateQuantity(productId, quantity);
    }
    @PostMapping("/clear")
    public void clearCart() { cartService.clearCart(); }
}
