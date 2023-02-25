package com.company.library.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanNo;
    @Column(nullable = false)
    private Long bookNo;
    @Column(nullable = false)
    private Long userNo;
    private LocalDateTime loanDt;
    private LocalDateTime dueDt;
    private LocalDateTime returnDt;
    private LocalDateTime updateDt;
    private int status;
    private String statusMemo;
    private int overDueDays;


    @Builder
    public Loan (Loan loan){
        this.loanNo = loan.loanNo;
        this.bookNo = loan.bookNo;
        this.userNo = loan.userNo;
        this.loanDt = loan.loanDt;
        this.dueDt = loan.dueDt;
        this.returnDt = loan.returnDt;
        this.updateDt = loan.updateDt;
        this.status = loan.status;
        this.statusMemo = loan.statusMemo;
        this.overDueDays = loan.overDueDays;

    }
}
