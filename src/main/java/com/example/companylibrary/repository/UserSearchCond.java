package com.example.companylibrary.repository;

import lombok.Data;

@Data
public class UserSearchCond {

    private String userName;
    private String department;

    public UserSearchCond(){

    }

    public UserSearchCond(String userName, String department){
        this.userName = userName;
        this.department = department;
    }
}
