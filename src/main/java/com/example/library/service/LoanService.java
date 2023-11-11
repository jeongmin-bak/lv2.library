package com.example.library.service;

import com.example.library.dto.BookResponseDto;
import com.example.library.dto.LoanRequestDto;
import com.example.library.dto.LoanResponseDto;
import com.example.library.entity.Loan;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public boolean checkLoanBook(Long userId, Long bookId) {
        // 반납할 수 있는 책인지 확인
        Optional<Loan> check = loanRepository.findLoanByBookIdAndUserId(bookId, userId);
        if (check.isEmpty()) {
            // 회원의 패널티가 있는지 확인
            // 회원의 대출 내역 기록
            Loan loan = new Loan();
            loan.setBookId(bookId);
            loan.setUserId(userId);
            loanRepository.save(loan);

            return true;
        }
        if (check.get().getReturnStatus() == "반납") {
            return true;
        }
        // 대출 성공 메시지
        return false;
    }

    private Loan findLoan(Long id){
        return loanRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("대출이력이 존재하지 않습니다.")
        );
    }

}
