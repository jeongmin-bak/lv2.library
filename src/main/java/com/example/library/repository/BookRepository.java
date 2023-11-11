package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findBookByBookId(Long bookId);
    Book findBookByTitle(String title);
    List<Book> findAllByOrderByCreatedAtAsc();

}
