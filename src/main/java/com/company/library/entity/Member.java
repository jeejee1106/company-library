package com.company.library.entity;

import com.company.library.security.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Member extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    private String department;

    private String position;

    @Column(nullable = false)
    private String loanAvailability;

    @Column(nullable = false)
    private String deleteYn;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Authority> roles = new ArrayList<>();

    public Member() {

    }

    public void changeRoles(List<Authority> roles) {
        this.roles = roles;
        roles.forEach(role -> role.changeMember(this));
    }
    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
