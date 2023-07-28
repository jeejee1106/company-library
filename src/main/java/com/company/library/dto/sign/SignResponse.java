package com.company.library.dto.sign;

import com.company.library.entity.Member;
import com.company.library.security.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class SignResponse {
    private String token;
    private Long id;
    private String userId;
    private String username;
    private List<Authority> roles = new ArrayList<>();

    public SignResponse(Member member) {
        this.id = member.getUserNo();
        this.userId = member.getUserId();
        this.username = member.getUsername();
        this.roles = member.getRoles();
    }
}
