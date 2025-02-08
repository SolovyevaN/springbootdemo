package com.nastyaborisova.spring.springbootdemo.exeption;

public class UserNotFindExeption extends RuntimeException {
    public UserNotFindExeption(String message) {
        super(message);
    }
}
