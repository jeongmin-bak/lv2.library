package com.example.library.dto;

import com.example.library.entity.Book;
import com.example.library.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {
    private String username;
    private String gender;
    private String phoneNumber;
    private String address;

    public MemberResponseDto(Member member) {
        this.username = member.getUsername();
        this.gender = member.getGender();
        this.phoneNumber = member.getPhoneNumber();
        this.address = member.getAddress();
    }
}
