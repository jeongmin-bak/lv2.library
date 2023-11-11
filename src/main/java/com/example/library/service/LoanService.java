package com.example.library.service;

import com.example.library.dto.BookResponseDto;
import com.example.library.dto.LoanRequestDto;
import com.example.library.dto.LoanResponseDto;
import com.example.library.dto.getUserResponseDto;
import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import com.example.library.entity.Result;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }


    @Transactional
    public Long returnBook(Long bookId) {
        Optional<Loan> loan = loanRepository.findLoanByBookId(bookId);
        if(loan.isEmpty()){
            throw new EntityNotFoundException("대출이력이 없습니다.");
        }

        if(loan.get().getReturnStatus().equals("대출중")){
            loan.get().setReturnStatus("반납");
            loan.get().update(loan.get().getReturnStatus().toString());
        }

        return bookId;
    }

    public getUserResponseDto getLoans(Long id){

        Optional<Loan> findUser = loanRepository.findLoanByUserId(id);
        if(findUser.isEmpty()){
            throw new NullPointerException("사용자의 대출내역이 없습니다.");
        }
        Optional<Member> member = memberRepository.findMemberByUserId(findUser.get().getUserId());
        Optional<Book> book = bookRepository.findBookByBookId(findUser.get().getBookId());

        return new getUserResponseDto(member, book, findUser);
        //return null;

    }

    public boolean checkLoanBook(Long userId, Long bookId) {
        // 반납할 수 있는 책인지 확인
        Optional<Loan> check = loanRepository.findLoanByBookIdAndUserId(bookId, userId);
        if (check.isEmpty()) {
            // 회원의 패널티가 있는지 확인
            // 회원의 대출 내역 기록
            Loan loan = new Loan();
            loan.setBookId(bookId);
            loan.setUserId(userId);
            loan.setReturnStatus("대출중");
            loanRepository.save(loan);

            return true;
        }
        if (check.get().getReturnStatus() == "반납") {
            return true;
        }
        // 대출 성공 메시지
        return false;
    }

//    private Optional<Loan> findLoan(Long id){
////        return loanRepository.findById(id).orElseThrow(() ->
////                new IllegalArgumentException("대출이력이 존재하지 않습니다.")
////        );
//        return loanRepository.findLoanByBookId(id);
//    }

}
