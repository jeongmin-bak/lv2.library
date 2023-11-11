package com.example.library.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name="Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "return_Status", nullable = true)
    private String returnStatus;
    @Column(name = "loan_Date", nullable = false)
    private LocalDate loanDate;

    @Column(name = "return_Date", nullable = true)
    private LocalDate returnDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
