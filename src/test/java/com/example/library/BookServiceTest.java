//package com.example.library;
//
//import com.example.library.entity.Book;
//import com.example.library.repository.BookRepository;
//import com.example.library.service.BookService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@Transactional
//public class BookServiceTest {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private BookService bookService;
//
//    @Test
//    void testBookList() throws IOException {
//        Book book = new Book();
//        book.setTitle("테스트");
//        Book savedAlbum = bookRepository.save(book);
//
//        Book book2 = new Book();
//        book.setTitle("테스트2");
//        Book savedAlbum2 = bookRepository.save(book);
//
//        List<Book> books = bookRepository.findAllByOrderByCreated_AtAsc();
//
//        assertEquals(2,books.size());
//    }
//
//
//}
