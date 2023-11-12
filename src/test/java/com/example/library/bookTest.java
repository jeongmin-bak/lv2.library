package com.example.library;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class bookTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    @Disabled
    void 도서_등록_기능_테스트(){
        //given
//        Book book = new Book();
//        BookRequestDto requestDto;
//        BookService bookService = new BookService(bookRepository);
//
//        //when
//        book.setTitle("책이름");
//        book.setAuthor("저자");
//        book.setLanguage("한국어");
//        book.setPublisher("2021-05-06");
//        book.setCreatedAt("2023-11-01");
//
//        //requestDto = new BookRequestDto(book);
//        //BookResponseDto result = bookService.createBook(requestDto);
//        //then
//
//        //assertThat(result.getBook_Id()).isEqualTo(6L);
    }

    @Test
    void 선택한_도서_조회_테스트(){
        //given
//        BookService bookService = new BookService(bookRepository);
//
//        //when
//        BookResponseDto result = bookService.findBook("책 이름");
//
//        //then
//        assertThat(result.getTitle()).isEqualTo("책 이름");
    }
}
