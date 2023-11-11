package com.example.library.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private String title;
    private String author;
    private String username;
    private String phoneNumber;

    public Result(String title, String author, String username, String phoneNumber) {
        this.title = title;
        this.author = author;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
}
