package com.company.library.dto;

import com.company.library.entity.Book;
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
    public class RequestBookDto {

        private Long bookNo;
        private String title;
        private int libraryNo;
        private String statusYn;
        private String reservationStatusYn;
        private String delYn;


        public Book toEntity(){
            return Book.builder()
                    .bookNo(bookNo)
                    .title(title)
                    .libraryNo(libraryNo)
                    .statusYn(statusYn)
                    .reservationStatusYn(reservationStatusYn)
                    .delYn(delYn)
                    .build();
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    public static class ResponseBookDto {
        private Long bookNo;
        private String title;
        private int libraryNo;
        private String statusYn;
        private String reservationStatusYn;
        private LocalDateTime createDt;
        private LocalDateTime updateDt;
        private String delYn;

        public ResponseBookDto(Book entity){
            this.bookNo = entity.getBookNo();
            this.title = entity.getTitle();
            this.libraryNo = entity.getLibraryNo();
            this.statusYn = entity.getStatusYn();
            this.reservationStatusYn = entity.getReservationStatusYn();
            this.createDt = entity.getCreateDt();
            this.updateDt = entity.getUpdateDt();
            this.delYn = entity.getDelYn();
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

}
