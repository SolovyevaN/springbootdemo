package com.nastyaborisova.spring.springbootdemo.controller;

import com.nastyaborisova.spring.springbootdemo.model.User;
import com.nastyaborisova.spring.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String listUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("age") int age,
                          RedirectAttributes redirectAttributes) {
        User user = new User(name, surname, age);
        userService.addUser(user);
        redirectAttributes.addAttribute("message", "User added successfully! ");
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("age") int age) {
        User user = userService.findById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/updateUser";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam("id") Long id, Model model) {
        User user = userService.findById(id);
        if (user != null) {
            model.addAttribute("user", user);
        } else {
            model.addAttribute("errorMessage", "User not found!");
        }
        return "findById";
    }
}
