package com.company.library.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Library extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String delYn;

    @Builder
    public Library(Long no, String name, String delYn) {
        this.no = no;
        this.name = name;
        this.delYn = delYn;
    }
}
