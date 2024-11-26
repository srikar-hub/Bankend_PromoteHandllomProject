package com.klu.BackendHandlooms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.BackendHandlooms.model.CartItems;

public interface CartItemsRepo extends JpaRepository<CartItems,Long>{
	
	List<CartItems> findByCart_Id(long cartId);
	

}
