package com.company.library.controller;

import com.company.library.dto.sign.SignInRequest;
import com.company.library.dto.sign.SignResponse;
import com.company.library.dto.sign.SignUpRequest;
import com.company.library.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final SignService signService;

    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signin(@RequestBody SignInRequest request) throws Exception {
        return new ResponseEntity<>(signService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register/user")
    public ResponseEntity<Boolean> signupUser(@RequestBody SignUpRequest request) throws Exception {
        request.changeRole("ROLE_USER");
        return new ResponseEntity<>(signService.register(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register/admin")
    public ResponseEntity<Boolean> signupAdmin(@RequestBody SignUpRequest request) throws Exception {
        request.changeRole("ROLE_ADMIN");
        return new ResponseEntity<>(signService.register(request), HttpStatus.OK);
    }
}
