package com.company.library.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String title;
    private int libraryNo;
    private String statusYn;
    private String reservationStatusYn;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String deleteYn;

}
