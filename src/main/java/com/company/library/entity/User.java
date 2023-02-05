package com.company.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String userId;
    private String password;
    private String userName;
    private String department;
    private String position;
    private String role;
    private String loanAvailability;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String deleteYn;

}
