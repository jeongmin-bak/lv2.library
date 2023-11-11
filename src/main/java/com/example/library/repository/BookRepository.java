package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{

    Book findBookByTitle(String title);
//    List<Book> findAllByOrderByCreated_AtDesc();

    List<Book> findAllByOrderByCreatedAtAsc();
}
