package com.example.library.dto;

import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import com.example.library.entity.Result;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
public class getUserResponseDto {
    private String title;
    private String author;
    private String username;
    private String phoneNumber;
    private LocalDateTime loanDate;

    public getUserResponseDto(String title, String author, String username, String phoneNumber) {
        this.title = title;
        this.author = author;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public getUserResponseDto(Optional<Member> member, Optional<Book> book, Optional<Loan> loan) {
        this.title = book.get().getTitle();
        this.author = book.get().getAuthor();
        this.username = member.get().getUsername();
        this.phoneNumber = member.get().getPhoneNumber();
        this.loanDate = loan.get().getLoanDate();
    }



}

