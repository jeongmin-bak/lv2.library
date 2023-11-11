package com.example.library.dto;

import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class LoanResponseDto {
    private Long loanId;

    private String returnStatus;

    private LocalDateTime loanDate;

    private LocalDateTime returnDate;

    private Long bookId;

    private Long memberId;

    public LoanResponseDto(Long loanId, String returnStatus, LocalDateTime loanDate, LocalDateTime returnDate) {
        this.returnStatus = returnStatus;
    }

    public LoanResponseDto(Loan loan){

    }

}
