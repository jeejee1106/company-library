package com.example.companylibrary;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String userName;
    private String department;
    public UserUpdateDto() {
    }
    public UserUpdateDto(String userName, String department) {
        this.userName = userName;
        this.department = department;
    }
}

