package com.example.library.controller;


import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.entity.Loan;
import com.example.library.service.BookService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //도서 등록 기능
    @PostMapping("/create")
    public BookResponseDto createBook(@RequestBody BookRequestDto requestDto){
        return bookService.createBook(requestDto);
    }

    //선택한 도서 정보 조회 기능

    @GetMapping("/book/{title}")
    public BookResponseDto findBook(@PathVariable String title){
        return bookService.findBook(title);
    }


    @GetMapping("/books")
    public List<BookResponseDto> getBooks() { return bookService.getBooks();}





}
