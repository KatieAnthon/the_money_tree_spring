package com.makers.moneytree.controller;
import com.makers.moneytree.model.User;
import com.makers.moneytree.repository.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @GetMapping("/")
//    public String landingPage() {
//        return "Welcome to The login page";
//    }

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }
}
