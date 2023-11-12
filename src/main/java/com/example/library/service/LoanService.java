package com.example.library.service;

import com.example.library.dto.LoanJoinDto;
import com.example.library.entity.Loan;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    public List<LoanJoinDto> getLoans(Long id){
        List<LoanJoinDto> loanJoin = loanRepository.loanJoin(id);
        return loanJoin;
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


}
