package com.example.library.dto;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class LoanRequestDto {

    private Long loanId;

    private String returnStatus;

    private LocalDateTime loanDate;

    private LocalDateTime returnDate;

    private Long bookId;

    private Long memberId;


}
