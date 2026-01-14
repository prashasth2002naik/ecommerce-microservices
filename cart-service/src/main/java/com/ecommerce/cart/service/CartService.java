package com.ecommerce.cart.service;
import com.ecommerce.cart.client.ProductClient;
import com.ecommerce.cart.model.CartItem;
import com.ecommerce.cart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@SessionScope
public class CartService {
    private List<CartItem> cartItems = new ArrayList<>();
    @Autowired
    private ProductClient productClient;
    public void addToCart(Long productId, Integer quantity) {
        Product product = productClient.getProductById(productId);
        Optional<CartItem> existingItem = cartItems.stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst();
        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            cartItems.add(new CartItem(product, quantity));
        }
    }
    public void removeFromCart(Long productId) {
        cartItems.removeIf(item -> item.getProduct().getId().equals(productId));
    }
    public void updateQuantity(Long productId, Integer quantity) {
        cartItems.stream().filter(item -> item.getProduct().getId().equals(productId))
            .findFirst().ifPresent(item -> item.setQuantity(quantity));
    }
    public List<CartItem> getCartItems() { return cartItems; }
    public Double getTotal() { return cartItems.stream().mapToDouble(CartItem::getSubtotal).sum(); }
    public void clearCart() { cartItems.clear(); }
    public int getCartSize() { return cartItems.stream().mapToInt(CartItem::getQuantity).sum(); }
}
