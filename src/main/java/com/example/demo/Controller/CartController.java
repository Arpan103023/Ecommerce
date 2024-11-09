package com.example.demo.Controller;
import com.example.demo.Product.CartRepository;
import com.example.demo.entity.CartItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Product.ProductRepository;
import com.example.demo.entity.CartItem;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addProductToCart(@RequestBody CartItem cartItem) {
        cartRepository.save(cartItem);
        return ResponseEntity.ok("Product added to cart successfully!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCartItem(@RequestBody CartItem cartItem) {
        cartRepository.save(cartItem);
        return ResponseEntity.ok("Cart item updated successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Long id) {
        cartRepository.deleteById(id);
        return ResponseEntity.ok("Cart item deleted successfully!");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCartByUser(@PathVariable Long userId) {
        List<CartItem> cartItems = cartRepository.findByUserId(userId);
        return ResponseEntity.ok(cartItems);
    }
}
