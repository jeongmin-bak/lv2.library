package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Book findBookByTitle(String title);
    List<Book> findAllByOrderByCreatedAtAsc();

}
