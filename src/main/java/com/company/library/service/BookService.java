package com.company.library.service;

import com.company.library.dto.BookDto;
import com.company.library.entity.Book;
import com.company.library.entity.QBook;
import com.company.library.entity.QLibrary;
import com.company.library.repository.BookRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    /**
     * JPAQueryFactory 는 별도의 스프링 빈을 등록하지 않고
     * EntityManager 는 주입받을 수 있으므로 이용하여 작성한다.
     */
    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    public void init(){
        jpaQueryFactory = new JPAQueryFactory(em);
    }


    public BookDto.ResponseBookDto save(BookDto.RequestBookDto book){
        Book entity = bookRepository.save(book.toEntity());
        return null;
//        return new BookDto.ResponseBookDto(entity);
    }

    public BookDto.ResponseBookDto findById(Long bookNo){
        Book entity = bookRepository.findById(bookNo).orElseThrow(IllegalArgumentException::new);
        //return new BookDto.ResponseBookDto(entity);
        return null;
    }

    public void put(BookDto.RequestBookDto book){
        Book entity = bookRepository.findById(book.getBookNo()).orElseThrow(IllegalArgumentException::new);

    }

    /**
     * 생성된 Q파일 이용
     * @return
     */
    public List<BookDto.ResponseBookDto> findBy(BookDto.BookSearchCondition requestBookDto){
        QBook bo = QBook.book;
        BookDto.ResponseBookDto book = new BookDto.ResponseBookDto();
        QLibrary library = QLibrary.library;
        return /*jpaQueryFactory.select(Projections.bean(BookDto.ResponseBookDto.class,
                        book.getBookNo(),
                        book.getTitle(),
                        book.getLibraryNo(),
                        book.getStatusYn(),
                        book.getReservationStatusYn(),
                        book.getCreateDt(),
                        book.getUpdateDt(),
                        book.getDelYn())).from(book)
                .innerJoin(library)
                .on(library.no.eq(requestBookDto.getLibraryNo()))
                .fetch();*/ null;

                /*jpaQueryFactory.select(new BookDto.ResponseBookListDto(
                book.bookNo, book.libraryNo
        ))*/
                /*.select(Projections.fields(
                                BookDto.ResponseBookListDto.class,
                                book.bookNo,
                                book.libraryNo))
                .from(book)
                .on(library.no.eq(requestBookDto.getLibraryNo()))
                .fetch();*/
    }

    public BookDto.ResponseBookListDto findAll(){
        List<Book> entity = bookRepository.findAll();
        return new BookDto.ResponseBookListDto(entity);
    }

    public BookDto.ResponseBookDto updateById(BookDto.UpdateBookDto book){
        Book entity = bookRepository.findById(book.getBookNo()).orElseThrow(IllegalArgumentException::new);
        entity.update(book.toEntity());
        bookRepository.save(entity);
        //return new BookDto.ResponseBookDto(entity);
        return null;
    }

    public ResponseEntity<Map<String, Object>> deleteById(Long bookNo){
        Map<String, Object> responseMap = new HashMap<>();
        bookRepository.delete(bookRepository.findById(bookNo).orElseThrow(IllegalArgumentException::new));
        responseMap.put("status", "200");
        responseMap.put("message", "delete");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}
