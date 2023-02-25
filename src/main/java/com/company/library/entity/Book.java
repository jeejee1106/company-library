package com.company.library.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@DynamicUpdate //변경 필드만 반영
public class Book extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookNo;
    @Column(nullable = false)
    private Long libraryNo;
    private String title;
    private String loanStatusYn;
    private String lossYn;
    private String resvStatusYn;
    private String delYn;

    @Builder
    public Book(Book book){
        this.bookNo = book.bookNo;
        this.libraryNo = book.libraryNo;
        this.title = book.title;
        this.loanStatusYn = book.loanStatusYn;
        this.lossYn = book.lossYn;
        this.resvStatusYn = book.resvStatusYn;
        this.delYn = book.delYn;
    }

}
