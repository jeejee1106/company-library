package com.company.library.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    private String department;

    private String position;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String loanAvailability;

    @Column(nullable = false)
    private String deleteYn;

    @Builder
    public User(Long userNo, String userId, String password, String userName, String department, String position, String role, String loanAvailability, String deleteYn) {
        this.userNo = userNo;
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.department = department;
        this.position = position;
        this.role = role;
        this.loanAvailability = loanAvailability;
        this.deleteYn = deleteYn;
    }
}
