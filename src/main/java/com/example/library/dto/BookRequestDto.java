package com.example.library.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class BookRequestDto {
    private String title;
    private String author;
    private String language;
    private String publisher;

}
