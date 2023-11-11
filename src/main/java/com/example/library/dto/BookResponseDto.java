package com.example.library.dto;

import com.example.library.entity.Book;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class BookResponseDto {
    private Long book_Id;
    private String title;
    private String author;
    private String language;
    private String publisher;
    private LocalDateTime createdAt;

    public BookResponseDto(Book book) {
        this.book_Id = book.getBookId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.createdAt = book.getCreatedAt();
    }
}
