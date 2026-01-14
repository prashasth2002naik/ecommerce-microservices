package com.ecommerce.webui.controller;
import com.ecommerce.webui.client.ProductClient;
import com.ecommerce.webui.client.CartClient;
import com.ecommerce.webui.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@Controller
public class WebController {
@Autowired private ProductClient productClient;
@Autowired private CartClient cartClient;
@Autowired private OrderClient orderClient;
@GetMapping("/")
public String home(Model model, @RequestParam(required = false) String search) {
model.addAttribute("products", productClient.getAllProducts(search));
Map<String, Object> cartSummary = cartClient.getCartSummary();
model.addAttribute("cartSize", cartSummary.get("size"));
return "index";
}
@PostMapping("/cart/add")
public String addToCart(@RequestParam Long productId, @RequestParam Integer quantity) {
cartClient.addToCart(productId, quantity);
return "redirect:/cart";
}
@GetMapping("/cart")
public String viewCart(Model model) {
Map<String, Object> cartSummary = cartClient.getCartSummary();
model.addAttribute("cartItems", cartSummary.get("items"));
model.addAttribute("total", cartSummary.get("total"));
model.addAttribute("cartSize", cartSummary.get("size"));
return "cart";
}
@PostMapping("/cart/remove")
public String removeFromCart(@RequestParam Long productId) {
cartClient.removeFromCart(productId);
return "redirect:/cart";
}
@PostMapping("/cart/update")
public String updateQuantity(@RequestParam Long productId, @RequestParam Integer quantity) {
cartClient.updateQuantity(productId, quantity);
return "redirect:/cart";
}
@PostMapping("/checkout")
public String checkout(Model model) {
Map<String, Object> cartSummary = cartClient.getCartSummary();
Double total = (Double) cartSummary.get("total");
orderClient.createOrder(total);
cartClient.clearCart();
model.addAttribute("total", total);
return "checkout";
}
}
