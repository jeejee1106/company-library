package com.example.companylibrary;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Import(JpaConfig.class)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
//    @AfterEach
//    void afterEach() {
//        //MemoryItemRepository 의 경우 제한적으로 사용
//        if (itemRepository instanceof MemoryItemRepository) {
//            ((MemoryItemRepository) itemRepository).clearStore();
//        }
//    }
    @Test
    void save() {
        //given
        User user = new User("itemA", "depart");
        //when
        User savedUser = userRepository.save(user);
        //then
        User findUser = userRepository.findById(user.getId()).get();
        assertThat(findUser).isEqualTo(savedUser);
    }
    @Test
    void updateUser() {
        //given
        User user = new User("item1", "de");
        User savedItem = userRepository.save(user);
        Long userId = savedItem.getId();
        //when
        UserUpdateDto updateParam = new UserUpdateDto("item2","d");
        userRepository.update(userId, updateParam);
        //then
        User findItem = userRepository.findById(userId).get();

        assertThat(findItem.getDepartment()).isEqualTo(updateParam.getDepartment());
        assertThat(findItem.getUserName()).isEqualTo(updateParam.getUserName());
    }/*
    @Test
    void findItems() {
        //given
        Item item1 = new Item("itemA-1", 10000, 10);
        Item item2 = new Item("itemA-2", 20000, 20);
        Item item3 = new Item("itemB-1", 30000, 30);
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        //둘 다 없음 검증
        test(null, null, item1, item2, item3);
        test("", null, item1, item2, item3);
        //itemName 검증
        test("itemA", null, item1, item2);
        test("temA", null, item1, item2);
        test("itemB", null, item3);
        //maxPrice 검증
        test(null, 10000, item1);
        //둘 다 있음 검증
        test("itemA", 10000, item1);
    }
    void test(String itemName, Integer maxPrice, Item... items) {
        List<Item> result = itemRepository.findAll(new ItemSearchCond(itemName,
                maxPrice));
        assertThat(result).containsExactly(items);
    }*/
}