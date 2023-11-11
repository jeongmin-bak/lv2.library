package com.example.library.controller;

import com.example.library.dto.LoanJoinDto;

import com.example.library.service.LoanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loan/{bookId}")
    public Long returnBook(@PathVariable Long bookId){
        return loanService.returnBook(bookId);
    }

    @GetMapping("/loan")
    public boolean checkLoan(@RequestParam Long user_Id, @RequestParam Long book_Id){
        return loanService.checkLoanBook(user_Id, book_Id);
    }

    @GetMapping("/loan/user/{userId}")
    public List<LoanJoinDto> getLoans(@PathVariable Long userId){
        return loanService.getLoans(userId);
    }
}
