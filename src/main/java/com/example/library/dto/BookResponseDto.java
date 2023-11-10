package com.example.library.dto;

import com.example.library.entity.Book;

public class BookResponseDto {
    private Long book_Id;
    private String title;
    private String author;
    private String language;
    private String publisher;
    private String created_At;

    public BookResponseDto(Book book) {
        this.book_Id = book.getBook_Id();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.created_At = book.getCreated_At();
    }
}
