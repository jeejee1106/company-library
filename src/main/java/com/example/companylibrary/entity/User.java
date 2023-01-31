package com.example.companylibrary.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;
    private String department;

    public User(){

    }
    public User(String userName, String department){
        this.userName = userName;
        this.department = department;
    }
}
