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

//    public BookRequestDto(Book book) {
//        this.title = book.getTitle();
//        this.author = book.getAuthor();
//        this.language = book.getLanguage();
//        this.publisher = book.getPublisher();
//        this.createdAt = book.getCreatedAt();
//    }

}
