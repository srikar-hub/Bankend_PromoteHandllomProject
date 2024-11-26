package com.klu.BackendHandlooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.BackendHandlooms.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long>{
	Cart findByUser_Id(Long userId);
    
}
