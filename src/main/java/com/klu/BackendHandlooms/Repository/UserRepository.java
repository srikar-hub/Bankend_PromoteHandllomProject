package com.klu.BackendHandlooms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.BackendHandlooms.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{
User findByEmail(String email);
boolean existsByEmail(String email);
}
