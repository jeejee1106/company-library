package com.company.library.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@DynamicUpdate //변경 필드만 반영
public class BookHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookHistoryNo;
    private Long bookNo;
    private Long libraryNo;
    private String lossYn;
    private LocalDateTime createDt;



}
