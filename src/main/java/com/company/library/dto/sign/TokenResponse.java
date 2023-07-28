package com.company.library.dto.sign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TokenResponse {

    private String token;
}
