package com.company.library.service;

import com.company.library.dto.BookDto;
import com.company.library.entity.Book;
import com.company.library.entity.QBook;
import com.company.library.entity.QLibrary;
import com.company.library.repository.BookRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final JPAQueryFactory jpaQueryFactory;


    public BookDto.ResponseBookDto save(BookDto.RequestBookDto book){
        Book entity = bookRepository.save(book.toEntity());
        return new BookDto.ResponseBookDto(entity);
    }

    public BookDto.ResponseBookDto findById(Long bookNo){
        Book entity = bookRepository.findById(bookNo).orElseThrow(IllegalArgumentException::new);
        return new BookDto.ResponseBookDto(entity);
    }

    /**
     * 생성된 Q파일 이용
     * @return
     */
    public List<BookDto.BookSearchCondition> findBy(){
        QBook book = QBook.book;
        QLibrary library = QLibrary.library;
        return jpaQueryFactory.select(Projections.fields(BookDto.BookSearchCondition.class, book.bookNo, book.libraryNo)).from(book).on(book.libraryNo.eq(library.no)).fetch();
    }

    public BookDto.ResponseBookListDto findAll(){
        List<Book> entity = bookRepository.findAll();
        return new BookDto.ResponseBookListDto(entity);
    }

    public BookDto.ResponseBookDto updateById(BookDto.UpdateBookDto book){
        Book entity = bookRepository.findById(book.getBookNo()).orElseThrow(IllegalArgumentException::new);
        entity.update(book.toEntity());
        bookRepository.save(entity);
        return new BookDto.ResponseBookDto(entity);
    }

    public ResponseEntity<Map<String, Object>> deleteById(Long bookNo){
        Map<String, Object> responseMap = new HashMap<>();
        bookRepository.delete(bookRepository.findById(bookNo).orElseThrow(IllegalArgumentException::new));
        responseMap.put("status", "200");
        responseMap.put("message", "delete");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}
