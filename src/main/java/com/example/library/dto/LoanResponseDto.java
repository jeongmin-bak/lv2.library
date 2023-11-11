package com.example.library.dto;

import com.example.library.entity.Member;
import lombok.Getter;

@Getter
public class LoanResponseDto {
    private String username;
    private String gender;
    private String phoneNumber;
    private String address;

    public LoanResponseDto(Member member) {
        this.username = member.getUsername();
        this.gender = member.getGender();
        this.phoneNumber = member.getPhoneNumber();
        this.address = member.getAddress();
    }
}
