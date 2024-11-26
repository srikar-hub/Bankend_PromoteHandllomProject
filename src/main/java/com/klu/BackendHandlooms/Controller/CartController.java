package com.klu.BackendHandlooms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.BackendHandlooms.model.Cart;
import com.klu.BackendHandlooms.model.CartItemRequestDTO;
import com.klu.BackendHandlooms.service.CartService;


@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return cartService.getCart(userId);  // Retrieve the cart for the user
    }
	@PostMapping("/addItem")
    public Cart addItemToCart(@RequestBody CartItemRequestDTO cartItemRequest) {
        return cartService.addItemToCart(
                cartItemRequest.getUserId(),
                cartItemRequest.getProductId(),
                cartItemRequest.getPrice(),
                cartItemRequest.getQuantity(),
                cartItemRequest.getTitle()
        );    // Add item to cart
    }
}
