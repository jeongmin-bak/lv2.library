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
        return new BookResponseDto(bookRepository.save(book));
    }

    // 선택한 도서 정보 조회 기능 - response 1개만
//    public Book findBook(String title){
//        return bookRepository.findBookByTitle(title);
//    }

    public List<BookResponseDto> getBooks() {
        return bookRepository.findAllByOrderByCreatedAtAsc().stream().map(BookResponseDto::new).toList();
    }
}
