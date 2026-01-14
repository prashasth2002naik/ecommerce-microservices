package com.ecommerce.product.service;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() { return productRepository.findAll(); }
    public Optional<Product> getProductById(Long id) { return productRepository.findById(id); }
    public List<Product> searchProducts(String keyword) { return productRepository.findByNameContainingIgnoreCase(keyword); }
    public Product saveProduct(Product product) { return productRepository.save(product); }
    @Override
    public void run(String... args) {
        productRepository.save(new Product("Laptop", "High-performance laptop", 999.99, 10, "https://via.placeholder.com/200"));
        productRepository.save(new Product("Smartphone", "Latest model smartphone", 699.99, 25, "https://via.placeholder.com/200"));
        productRepository.save(new Product("Headphones", "Noise-canceling headphones", 199.99, 50, "https://via.placeholder.com/200"));
        productRepository.save(new Product("Tablet", "10-inch tablet", 449.99, 15, "https://via.placeholder.com/200"));
        productRepository.save(new Product("Smartwatch", "Fitness tracking smartwatch", 299.99, 30, "https://via.placeholder.com/200"));
        productRepository.save(new Product("Camera", "Digital camera", 799.99, 8, "https://via.placeholder.com/200"));
    }
}
