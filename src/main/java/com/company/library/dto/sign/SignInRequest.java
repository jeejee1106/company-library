package com.company.library.dto.sign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString(of = {"userId", "password"})
public class SignInRequest {
    private String userId;
    private String password;

    public SignInRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
