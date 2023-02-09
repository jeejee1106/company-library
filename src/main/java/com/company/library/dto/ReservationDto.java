package com.company.library.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private Long no;
    private int bookNo;
    private int userNo;
    private int status;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}
