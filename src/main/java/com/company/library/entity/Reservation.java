package com.company.library.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationNo;

    @Column(nullable = false)
    private int bookNo;

    @Column(nullable = false)
    private int userNo;

    @Column(nullable = false)
    private int status;

    private String statusMemo;

    private LocalDateTime reservationDt;
    private LocalDateTime updateDt;

    @Builder
    public Reservation(Long reservationNo, int bookNo, int userNo, int status, String statusMemo, LocalDateTime reservationDt, LocalDateTime updateDt) {
        this.reservationNo = reservationNo;
        this.bookNo = bookNo;
        this.userNo = userNo;
        this.status = status;
        this.statusMemo = statusMemo;
        this.reservationDt = reservationDt;
        this.updateDt = updateDt;
    }

}
