package com.example.library.dto;

import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LoanResponseDto {
    private Long loanId;

    private String returnStatus;

    private LocalDate loanDate;

    private LocalDate returnDate;

    private Long bookId;

    private Long memberId;

    public LoanResponseDto(Long loanId, String returnStatus, LocalDate loanDate, LocalDate returnDate) {
        this.returnStatus = returnStatus;
    }

    public LoanResponseDto(Loan loan){

    }

}
