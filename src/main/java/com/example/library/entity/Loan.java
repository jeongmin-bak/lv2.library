package com.example.library.entity;

import com.example.library.dto.LoanRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Loan")
public class Loan{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "return_Status", nullable = true)
    private String returnStatus;

    @Column(name = "loan_Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDate loanDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_Date", nullable = true)
    private LocalDate returnDate;

    @Column(name = "book_Id", nullable = false)
    private Long bookId;

    @Column(name = "user_Id", nullable = false)
    private Long userId;

    public void update(LoanRequestDto requestDto) {
       this.returnStatus = requestDto.getReturnStatus();
    }
}
