package com.company.library.entity;

import com.company.library.security.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    private String department;

    private String position;

    @Column(nullable = false)
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Authority> roles = new ArrayList<>();


    @Column(nullable = false)
    private String loanAvailability;

    @Column(nullable = false)
    private String deleteYn;

    @Builder
    public User(Long userNo, String userId, String password, String userName, String department, String position, List<Authority> roles, String loanAvailability, String deleteYn) {
        this.userNo = userNo;
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.department = department;
        this.position = position;
        this.roles = roles;
        this.loanAvailability = loanAvailability;
        this.deleteYn = deleteYn;
    }

    public void changeRoles(List<Authority> roles) {
        this.roles = roles;
        roles.forEach(role -> role.changeMember(this));
    }
}
