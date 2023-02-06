package com.company.library.dto;

import com.company.library.entity.Book;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Getter
@NoArgsConstructor
public class RequestBookDto {

    private Long bookNo;
    private String title;
    private int libraryNo;
    private String statusYn;
    private String reservationStatusYn;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private String delYn;

    @Builder
    public RequestBookDto(Long bookNo,
                          String title,
                          int libraryNo,
                          String statusYn,
                          String reservationStatusYn,
                          LocalDateTime createDt,
                          LocalDateTime updateDt,
                          String delYn){
        this.bookNo = bookNo;
        this.title = title;
        this.libraryNo = libraryNo;
        this.statusYn = statusYn;
        this.reservationStatusYn = reservationStatusYn;
        this.createDt = createDt;
        this.updateDt = updateDt;
        this.delYn = delYn;
    }

    public Book toEntity(){
        return Book.builder()
                .bookNo(bookNo)
                .title(title)
                .libraryNo(libraryNo)
                .statusYn(statusYn)
                .reservationStatusYn(reservationStatusYn)
                .createDt(createDt)
                .updateDt(updateDt)
                .delYn(delYn)
                .build();
    }
}
