package com.company.library.controller;

import com.company.library.dto.BookDto;
import com.company.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PatchMapping("/{bookNo}")
    public ResponseEntity<BookDto.ResponseBookDto> updateBook(BookDto.UpdateBookDto book){
        return new ResponseEntity<>(bookService.updateById(book), HttpStatus.OK);
    }

    @DeleteMapping("/{bookNo}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long bookNo) {
        return bookService.deleteById(bookNo);
    }

}
