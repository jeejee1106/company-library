package com.example.companylibrary;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String department;

    public User(){

    }
    public User(String userName, String department){
        this.userName = userName;
        this.department = department;
    }
}
