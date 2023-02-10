package com.company.library.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@DynamicUpdate //변경 필드만 반영
public class Book extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookNo;

    private String title;
    private int libraryNo;
    private String statusYn;
    private String reservationStatusYn;
    private String delYn;

    @Builder
    public Book(Long bookNo,
                String title,
                int libraryNo,
                String statusYn,
                String reservationStatusYn,
                String delYn
    ){
        this.bookNo = bookNo;
        this.title = title;
        this.libraryNo = libraryNo;
        this.statusYn = statusYn;
        this.reservationStatusYn = reservationStatusYn;
        this.delYn = delYn;
    }

    public void update(Book book) {
        this.bookNo = book.getBookNo();
        this.title = book.getTitle();
        this.libraryNo = book.getLibraryNo();
        this.statusYn = book.getStatusYn();
        this.reservationStatusYn = book.getReservationStatusYn();
        this.delYn = book.getDelYn();
    }


}
