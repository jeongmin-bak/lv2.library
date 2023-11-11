package com.example.library.controller;


import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto requestDto){
        return new ResponseEntity<>(bookService.createBook(requestDto),HttpStatus.OK);
    }

    //선택한 도서 정보 조회 기능

    @GetMapping("/book/{title}")
    public ResponseEntity<BookResponseDto> findBook(@PathVariable String title){
        return new ResponseEntity<>(bookService.findBook(title),HttpStatus.OK);
    }

    //도서 목록 조회 기능
    @GetMapping("/books")
    public ResponseEntity<List<BookResponseDto>> getBooks() { return new ResponseEntity<>(bookService.getBooks(),HttpStatus.OK);}





}
