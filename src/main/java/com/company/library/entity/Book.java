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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long bookNo;
    private Long libraryNo;
    private String title;
    private String loanStatusYn;
    private String lossYn;
    private String resvStatusYn;
    private String delYn;

    @Builder
    public Book(Long bookNo,
                Long libraryNo,
                String title,
                String loanStatusYn,
                String lossYn,
                String resvStatusYn,
                String delYn
    ){
        this.bookNo = bookNo;
        this.libraryNo = libraryNo;
        this.title = title;
        this.loanStatusYn = loanStatusYn;
        this.lossYn = lossYn;
        this.resvStatusYn = resvStatusYn;
        this.delYn = delYn;
    }

    public void update(Book book) {
        this.bookNo = book.getBookNo();
        this.libraryNo = book.getLibraryNo();
        this.title = book.getTitle();
        this.loanStatusYn = book.getLoanStatusYn();
        this.lossYn = book.getLossYn();
        this.resvStatusYn = book.getResvStatusYn();
        this.delYn = book.getDelYn();
    }


}
