package com.example.companylibrary.controller;

import com.example.companylibrary.entity.User;
import com.example.companylibrary.repository.UserRepository;
import com.example.companylibrary.repository.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/{userId}/update")
    public void edit(@PathVariable Long userId, @ModelAttribute UserUpdateDto updateParam) {
        userRepository.update(userId, updateParam);
    }

    @GetMapping("/{userId}")
    public Optional<User> user(@PathVariable long userId) {
        return userRepository.findById(userId);
    }

}
