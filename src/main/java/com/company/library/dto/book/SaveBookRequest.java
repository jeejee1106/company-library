package com.company.library.dto.book;

import com.company.library.entity.Book;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"libraryNo", "title", "loanStatusYn"})
public class SaveBookRequest {
    private Long libraryNo;
    private String title;
    private String loanStatusYn;

    public Book toEntity(){
        return Book.builder()
                .libraryNo(libraryNo)
                .title(title)
                .loanStatusYn(loanStatusYn)
                .build();
    }
}
