package com.klu.BackendHandlooms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.BackendHandlooms.model.Cart;
import com.klu.BackendHandlooms.model.CartItems;
import com.klu.BackendHandlooms.model.User;
import com.klu.BackendHandlooms.repository.CartItemsRepo;
import com.klu.BackendHandlooms.repository.CartRepo;
import com.klu.BackendHandlooms.repository.UserRepository;

@Service
public class CartService {
	
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CartItemsRepo cartItemsRepo;
	
	public Cart getCart(Long userid) {
		return cartRepo.findByUser_Id(userid);
	}
	public Cart createOrGetCart(Long userId) {
	    // First, check if the user exists in the database
	    User user = ur.findById(userId).orElse(null);
	    if (user == null) {
	        // If the user does not exist, you can throw an exception or return null or an error message
	        throw new RuntimeException("User with ID " + userId + " does not exist.");
	    }

	    // Try to get the cart for the user
	    Cart cart = cartRepo.findByUser_Id(userId);
	    if (cart == null) {
	        // If the cart doesn't exist for the user, create a new cart and associate it with the user
	        cart = new Cart();
	        cart.setUser(user);  // Set the existing user in the cart
	        cartRepo.save(cart);
	    }

	    return cart;  // Return the existing or newly created cart
	}
    // Add item to cart
    public Cart addItemToCart(long userId, long productId, double price, int quantity, String title) {
        Cart cart = createOrGetCart(userId); // Get the cart (create if doesn't exist)

        // Loop through the cart items to check if the product already exists
        List<CartItems> items = cart.getItems();
        boolean itemExists = false;

        for (CartItems item : items) {
            if (item.getItemId()==productId) {
                itemExists = true;
                item.setQuantity(item.getQuantity() + quantity); // Update quantity if item exists
                break;
            }
        }

       
        if (!itemExists) {
            CartItems newItem = new CartItems(productId, price, quantity,title);
            cart.getItems().add(newItem);
        }

        return cartRepo.save(cart); // Save the updated cart
    }
    
    
    //to get the items in the cart
    
    
    public List<CartItems> getCartItemsForUser(long userId) {
    	Cart userCart = cartRepo.findByUser_Id(userId);
    	
    	if(userCart != null) {
    		// fetch all the items or carts of the user
    		return cartItemsRepo.findByCart_Id(userCart.getId());
    	}
    	else {
    		return new ArrayList<>();
    	}
		
    	
    }
	
	

}
