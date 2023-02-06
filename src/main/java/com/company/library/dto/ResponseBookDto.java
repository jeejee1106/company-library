package com.company.library.dto;

import com.company.library.entity.Book;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class ResponseBookDto {
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
