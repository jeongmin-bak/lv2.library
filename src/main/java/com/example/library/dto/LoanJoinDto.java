package com.example.library.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class LoanJoinDto {
    private String username;
    private String phoneNumber;
    private String title;
    private String author;
    private LocalDateTime loanDate;

    public LoanJoinDto(String username, String phoneNumber, String title, String author, LocalDateTime loanDate) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.author = author;
        this.loanDate = loanDate;
    }
}
