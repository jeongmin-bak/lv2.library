package com.example.library.dto;

import com.example.library.entity.Book;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {
    private String title;
    private String author;
    private String language;
    private String publisher;
    private String createdAt;


}
