package com.example.companylibrary;

import com.example.companylibrary.config.JpaConfig;
import com.example.companylibrary.repository.UserSearchCond;
import com.example.companylibrary.repository.UserUpdateDto;
import com.example.companylibrary.entity.User;
import com.example.companylibrary.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
@Import(JpaConfig.class)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    /* @Test
    void save() {
        //given
        User user = new User("UserId", "saveUserName", "saveDepartment");
        //when
        User savedUser = userRepository.save(user);
        //then
        User findUser = userRepository.findById(user.getId()).get();
        assertThat(findUser).isEqualTo(savedUser);
    }
    @Test
    void updateUser() {
        //given
        User user = new User("userId1", "updateUserName1", "updateUser1");
        User savedItem = userRepository.save(user);
        Long userId = savedItem.getId();
        //when
        UserUpdateDto updateParam = new UserUpdateDto("updateUserName2","updateUser2");
        userRepository.update(userId, updateParam);
        //then
        User findItem = userRepository.findById(userId).get();

        assertThat(findItem.getDepartment()).isEqualTo(updateParam.getDepartment());
        assertThat(findItem.getUserName()).isEqualTo(updateParam.getUserName());
    }
   @Test
    void findItems() {
        //given
        User user1 = new User("userId1","findUserName1", "updateUser1");
        User user2 = new User("userId2","findUserName2", "updateUser2");
        User user3 = new User("userId3","findUserName3", "updateUser3");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        //여기서 3개 이상이 조회되는 문제가 발생
        test(null, null, user1, user2, user3);
    }*/
    void test(String userName, String department, User... users) {
        List<User> result = userRepository.findAll(new UserSearchCond(userName,
                department));
        Assertions.assertThat(result).containsExactly(users);
    }
}