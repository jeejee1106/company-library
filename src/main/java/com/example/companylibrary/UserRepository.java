package com.example.companylibrary;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    void update(Long userId, UserUpdateDto updateParam);
    Optional<User> findById(Long id);
    //List<User> findAll(UserSearchCond cond);
}
