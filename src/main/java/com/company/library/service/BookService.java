package com.company.library.service;

import com.company.library.dto.BookDto;
import com.company.library.entity.Book;
import com.company.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookDto.ResponseBookDto save(BookDto.RequestBookDto book){
        Book entity = bookRepository.save(book.toEntity());
        return new BookDto.ResponseBookDto(entity);
    }

    public BookDto.ResponseBookDto findById(Long bookNo){
        Book entity = bookRepository.findById(bookNo).orElseThrow(() -> new IllegalArgumentException());
        return new BookDto.ResponseBookDto(entity);
    }

    public BookDto.ResponseBookListDto findAll(){
        List<Book> entity = bookRepository.findAll();
        return new BookDto.ResponseBookListDto(entity);
    }
    public BookDto.ResponseBookDto updateById(BookDto.UpdateBookDto book){
        Book entity = bookRepository.findById(book.getBookNo()).orElseThrow(() -> new IllegalArgumentException());
        entity.update(book.toEntity());
        bookRepository.save(entity);
        return new BookDto.ResponseBookDto(entity);
    }

/*
    public void deleteById(Long bookNo){
        bookRepository.deleteById(bookNo);
    }*/
}
