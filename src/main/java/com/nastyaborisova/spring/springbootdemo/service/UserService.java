package com.nastyaborisova.spring.springbootdemo.service;

import com.nastyaborisova.spring.springbootdemo.model.User;
import com.nastyaborisova.spring.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
       return userRepository.save(user);
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
