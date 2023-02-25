package com.company.library.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@DynamicUpdate //변경 필드만 반영
public class BookHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookHistoryNo;
    @Column(nullable = false)
    private Long bookNo;
    private Long libraryNo;
    private String lossYn;
    private LocalDateTime createDt;


    @Builder
    public BookHistory(BookHistory bookHistory) {
        this.bookHistoryNo = bookHistory.bookHistoryNo;
        this.bookNo = bookHistory.bookNo;
        this.libraryNo = bookHistory.libraryNo;
        this.lossYn = bookHistory.lossYn;
        this.createDt = bookHistory.createDt;
    }

}
