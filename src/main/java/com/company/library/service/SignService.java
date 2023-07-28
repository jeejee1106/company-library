package com.company.library.service;

import com.company.library.dto.sign.SignInRequest;
import com.company.library.dto.sign.SignResponse;
import com.company.library.dto.sign.SignUpRequest;
import com.company.library.entity.Member;
import com.company.library.repository.MemberRepository;
import com.company.library.security.Authority;
import com.company.library.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@AllArgsConstructor
public class SignService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;

    public SignResponse login(SignInRequest request) throws Exception {
        Member member = memberRepository.findByUserId(request.getUserId()).orElseThrow(() -> {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        });

        if (!encoder.matches(request.getPassword(), encoder.encode(member.getPassword()))) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .id(member.getUserNo())
                .userId(member.getUserId())
                .username(member.getUsername())
                .roles(member.getRoles())
                .token("Bearer " + jwtProvider.createToken(member.getUserId(), member.getRoles()))
                .build();
    }

    public boolean register(SignUpRequest request) throws Exception {
        try {
            Member member = Member.builder()
                    .userId(request.getUserId())
                    .password(request.getPassword())
                    .username(request.getUsername())
                    .build();
            member.changeRoles(Collections.singletonList(Authority.builder().name(request.getRole()).build()));



            memberRepository.save(member);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }
}
