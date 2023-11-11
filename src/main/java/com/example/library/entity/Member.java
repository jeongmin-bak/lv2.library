package com.example.library.entity;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.MemberRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone_Number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "social_Number", nullable = false, unique = true)
    private String socialNumber;

    public Member(MemberRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.gender = requestDto.getGender();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.address = requestDto.getAddress();
        this.socialNumber = requestDto.getSocialNumber();
    }
}
