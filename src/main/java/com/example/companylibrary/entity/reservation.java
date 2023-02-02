package com.example.companylibrary.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private int bookNo;
    private int userNo;
    private int status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;



}
