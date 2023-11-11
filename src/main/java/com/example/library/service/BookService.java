package com.example.library.service;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    public BookService(BookRepository bookRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    // 도서 등록 기능
    public BookResponseDto createBook(BookRequestDto requestDto) {
        Book book = new Book(requestDto);

        return new BookResponseDto(bookRepository.save(book));
    }

    // 선택한 도서 정보 조회 기능 - response 1개만
    public BookResponseDto findBook(String title){
        Book book = bookRepository.findBookByTitle(title);
        return new BookResponseDto(book);
    }

    public boolean checkLoanBook(String userId, String bookId) {
        // 반납할 수 있는 책인지 확인
        Optional<Loan> check = loanRepository.findLoanByBookIdAndUserId(bookId, userId);
        if(check.isEmpty()){
            // 회원의 패널티가 있는지 확인
            // 회원의 대출 내역 기록
            Loan loan = new Loan();
            loan.setBookId(bookId);
            loan.setUserId(userId);
            loanRepository.save(loan);

            return true;
        }
        if(check.get().getReturnStatus()=="반납"){
            return true;
        }
        // 대출 성공 메시지
        return false;
    }
}
