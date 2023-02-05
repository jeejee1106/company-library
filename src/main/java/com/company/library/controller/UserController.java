package com.company.library.controller;

import com.company.library.repository.UserRepository;
import com.company.library.entity.User;
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


}
