package com.example.library.dto;

import com.example.library.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long userId;
    private String username;
    private String gender;
    private String phoneNumber;
    private String address;

    public MemberResponseDto(Member member) {
        this.userId = member.getUserId();
        this.username = member.getUsername();
        this.gender = member.getGender();
        this.phoneNumber = member.getPhoneNumber();
        this.address = member.getAddress();

    }
}
