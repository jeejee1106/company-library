package com.company.library.controller;

import com.company.library.dto.BookDto;
import com.company.library.entity.Book;
import com.company.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto.ResponseBookDto> save(BookDto.RequestBookDto book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }

    @GetMapping("/{bookNo}")
    public ResponseEntity<BookDto.ResponseBookDto> getBook(@PathVariable Long bookNo){
        return new ResponseEntity<>(bookService.findById(bookNo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BookDto.ResponseBookListDto> getAllBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }
/*
    @PostMapping("/update/{bookNo}")
    public ResponseEntity<BookDto.ResponseBookDto> updateBook(@PathVariable Long bookNo, BookDto.RequestBookDto book){
        bookService.updateById(bookNo, book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/delete/{bookNo}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookNo){
        bookService.deleteById(bookNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
