package com.example.library.service;

import com.example.library.dto.BookResponseDto;
import com.example.library.dto.LoanRequestDto;
import com.example.library.dto.LoanResponseDto;
import com.example.library.entity.Loan;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    @Transactional
    public Long returnBook(Long bookId, LoanRequestDto requestDto) {
        Loan loan = findLoan(bookId);
        loan.setReturnStatus("반납완료");
        loan.update(requestDto);
        return bookId;
    }

    public List<LoanResponseDto> getLoans(Long id) {
        Loan loan = findLoan(id);

        return loanRepository.findByUserIdOrderByLoanDateAsc().stream().map(LoanResponseDto::new).toList();


    }

    private Loan findLoan(Long id){
        return loanRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("대출이력이 존재하지 않습니다.")
        );
    }

}
