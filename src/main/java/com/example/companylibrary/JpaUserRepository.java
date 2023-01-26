package com.example.companylibrary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class JpaUserRepository implements UserRepository{


    private final EntityManager em;

    public JpaUserRepository(EntityManager em){
        this.em = em;
    }

    public User save(User user){
        em.persist(user);
        return user;
    }
    public void update(Long userId, UserUpdateDto updateParam){
        User findUser = em.find(User.class, userId);
        findUser.setUserName(updateParam.getUserName());
        findUser.setDepartment(updateParam.getDepartment());

    }

    public Optional<User> findById(Long id){
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }
}
