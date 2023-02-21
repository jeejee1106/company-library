package com.company.library.service;

import com.company.library.repository.BookHistoryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class BookHistoryService {

    private final BookHistoryRepository bookHistoryRepository;
    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    public void init(){
        jpaQueryFactory = new JPAQueryFactory(em);
    }

}
