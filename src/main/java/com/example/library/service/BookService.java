package com.example.library.service;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
    }

    // 도서 등록 기능
    public BookResponseDto createBook(BookRequestDto requestDto) {
        Book book = new Book(requestDto);
        return new BookResponseDto(bookRepository.save(book));
    }


    public BookResponseDto findBook(String title){
        Book book = bookRepository.findBookByTitle(title);
        return new BookResponseDto(book);
    }

    public List<BookResponseDto> getBooks() {
        return bookRepository.findAllByOrderByCreatedAtAsc().stream().map(BookResponseDto::new).toList();
    }
}
