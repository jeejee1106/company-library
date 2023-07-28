package com.company.library.dto.sign;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//회원가입
@Getter
@NoArgsConstructor
@ToString(of = {"id", "userId", "password", "username", "department", "position", "role"})
public class SignUpRequest {
    @Schema(hidden = true)
    private Long id;
    private String userId;
    private String password;
    private String username;
    private String department;
    private String position;
    @Schema(hidden = true)
    private String role;

    public void changeRole(String role) {
        this.role = role;
    }
}
