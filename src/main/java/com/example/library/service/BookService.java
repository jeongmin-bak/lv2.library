package com.example.library.service;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 도서 등록 기능
    public BookResponseDto createBook(BookRequestDto requestDto) {
        Book book = new Book(requestDto);

        Book saveBook = bookRepository.save(book);

        BookResponseDto bookResponseDto = new BookResponseDto(book);
        return bookResponseDto;
    }

    // 선택한 도서 정보 조회 기능 - response 1개만
    public List<?> findBook(String title){
        return bookRepository.findAllByBook_Id().stream().map(BookResponseDto::new).toList();
    }
}
