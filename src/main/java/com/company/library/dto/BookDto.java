package com.company.library.dto;

import com.company.library.entity.Book;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
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
            return Book.builder()
                    .bookNo(bookNo)
                    .libraryNo(libraryNo)
                    .title(title)
                    .loanStatusYn(loanStatusYn)
                    .lossYn(lossYn)
                    .resvStatusYn(resvStatusYn)
                    .delYn(delYn)
                    .build();
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

        public ResponseBookDto(Long bookNo, Long libraryNo, String title, String loanStatusYn, String lossYn, String resvStatusYn, String delYn){
            this.bookNo = bookNo;
            this.libraryNo = libraryNo;
            this.title = title;
            this.loanStatusYn = loanStatusYn;
            this.lossYn = lossYn;
            this.resvStatusYn = resvStatusYn;
            this.delYn = delYn;
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
            return Book.builder()
                    .bookNo(bookNo)
                    .libraryNo(libraryNo)
                    .title(title)
                    .loanStatusYn(loanStatusYn)
                    .lossYn(lossYn)
                    .resvStatusYn(resvStatusYn)
                    .delYn(delYn)
                    .build();
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
        public BookSearchCondition(Long bookNo, Long libraryNo, String title, String loanStatusYn, String lossYn, String resvStatusYn, String delYn){
            this.bookNo = bookNo;
            this.libraryNo = libraryNo;
            this.title = title;
            this.loanStatusYn = loanStatusYn;
            this.lossYn = lossYn;
            this.resvStatusYn = resvStatusYn;
            this.delYn = delYn;
        }
    }
}
