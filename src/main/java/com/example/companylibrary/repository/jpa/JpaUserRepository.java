package com.example.companylibrary.repository.jpa;

import com.example.companylibrary.entity.User;
import com.example.companylibrary.repository.UserUpdateDto;
import com.example.companylibrary.repository.UserRepository;
import com.example.companylibrary.repository.UserSearchCond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class JpaUserRepository implements UserRepository {


    private final EntityManager em;

    public JpaUserRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public User save(User user){
        em.persist(user);
        return user;
    }
    @Override
    public void update(Long userId, UserUpdateDto updateParam){
        User findUser = em.find(User.class, userId);
        findUser.setUserName(updateParam.getUserName());
        findUser.setDepartment(updateParam.getDepartment());

    }
    @Override
    public Optional<User> findById(Long id){
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll(UserSearchCond cond){
        String jpql = "select u from User u";

        List<User> result = em.createQuery(jpql, User.class)
                .getResultList();

        return result;
    }


}
