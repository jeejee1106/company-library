package com.company.library.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
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



}
