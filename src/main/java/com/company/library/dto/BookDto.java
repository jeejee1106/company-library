package com.company.library.dto;

import com.company.library.entity.Book;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RequestBookDto {

        private Long bookNo;
        private Long libraryNo;
        private String title;
        private String loanStatusYn;
        private String lossYn;
        private String resvStatusYn;
        private String delYn;

        public Book toEntity(){
            return Book.builder().build();
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    public static class ResponseBookDto {
        private Long bookNo;
        private Long libraryNo;
        private String title;
        private String loanStatusYn;
        private String lossYn;
        private String resvStatusYn;
        private String delYn;

        public ResponseBookDto(Book book){
            this.bookNo = book.getBookNo();
            this.libraryNo = book.getLibraryNo();
            this.title = book.getTitle();
            this.loanStatusYn = book.getLoanStatusYn();
            this.lossYn = book.getLossYn();
            this.resvStatusYn = book.getResvStatusYn();
            this.delYn = book.getDelYn();
        }

    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class ResponseBookListDto {
        List<Book> list;

        public ResponseBookListDto(List<Book> list) {
            this.list = list;
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    public static class UpdateBookDto {

        private Long bookNo;
        private Long libraryNo;
        private String title;
        private String loanStatusYn;
        private String lossYn;
        private String resvStatusYn;
        private String delYn;


        public Book toEntity(){
            return Book.builder().build();
        }
    }

    //검색 조건으로 사용됨
    //책 이름, 최대 번호 (책 이름의 일부만 포함되어도 검색 가능해야 함)

    @Getter
    @Setter
    @NoArgsConstructor
    public static class BookSearchCondition {
        private Long bookNo;
        private Long libraryNo;
        private String title;
        private String loanStatusYn;
        private String lossYn;
        private String resvStatusYn;
        private String delYn;

        @QueryProjection
        public BookSearchCondition(Book book){
            this.bookNo = book.getBookNo();
            this.libraryNo = book.getLibraryNo();
            this.title = book.getTitle();
            this.loanStatusYn = book.getLoanStatusYn();
            this.lossYn = book.getLossYn();
            this.resvStatusYn = book.getResvStatusYn();
            this.delYn = book.getDelYn();
        }
    }
}
