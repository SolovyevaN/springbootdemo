package com.nastyaborisova.spring.springbootdemo.service;

import com.nastyaborisova.spring.springbootdemo.model.User;
import com.nastyaborisova.spring.springbootdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        if (!userRepository.existsById(user.getId())){
            throw new UserNotFindExeption("User with id " + user.getId() + " not found");
        }
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFindExeption ("User with id " + id + " not found"));
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFindExeption("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    static class UserNotFindExeption extends RuntimeException {
        public UserNotFindExeption(String message) {
            super(message);
        }
    }
}
