package com.example.library.repository;

import com.example.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findLoanByBookIdAndUserId(Long bookId, Long userId);
    List<Loan> findByUserIdOrderByLoanDateAsc();
}