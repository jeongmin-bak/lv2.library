package com.example.library.controller;


import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.service.BookService;
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
    // 타이틀인데 책이 여러개 나오면..? List<BookResponseDto>? 로 받아야 되나
    @GetMapping("/book/{title}")
    public List<?> findBook(@PathVariable String title){
        return bookService.findBook(title);
    }



}
