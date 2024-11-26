package com.klu.BackendHandlooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.BackendHandlooms.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
User findByEmail(String email);
boolean existsByEmail(String email);
User findById(int userid);
}
