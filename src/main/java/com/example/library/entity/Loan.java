package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name="Loan")
@Getter
@Setter
public class Loan extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loan_Id;

    @Column(name = "book_Id")
    private String bookId;

    @Column(name = "user_Id")
    private String userId;

    @Column(name = "return_Status")
    private String returnStatus;

    @Column(name = "loan_Date")
    private LocalDate loanDate;

    @Column(name = "return_Date")
    private LocalDate returnDate;


}
