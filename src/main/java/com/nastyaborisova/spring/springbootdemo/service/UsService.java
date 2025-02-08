package com.nastyaborisova.spring.springbootdemo.service;

import com.nastyaborisova.spring.springbootdemo.model.User;

import java.util.List;

public interface UsService {
    void addUser(User user);
    void updateUser(User user);
    User findById(Long id);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
