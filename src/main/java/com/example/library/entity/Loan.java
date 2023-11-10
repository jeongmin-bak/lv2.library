package com.example.library.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name="Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loan_Id;

    @Column(name = "return_Status", nullable = false)
    private String return_Status;
    @Column(name = "loan_Date", nullable = false)
    private LocalDate loan_Date;

    @Column(name = "return_Date", nullable = false)
    private LocalDate return_Date;
}
