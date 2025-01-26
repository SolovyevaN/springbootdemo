package com.nastyaborisova.spring.springbootdemo.repository;

import com.nastyaborisova.spring.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
