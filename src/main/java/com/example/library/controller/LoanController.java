package com.example.library.controller;

import com.example.library.dto.LoanJoinDto;
import com.example.library.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // 도서 대출 반납 기능
    @GetMapping("/loan/return/{bookId}")
    public ResponseEntity<Long> returnBook(@PathVariable Long bookId){
        return new ResponseEntity<>(loanService.returnBook(bookId), HttpStatus.OK);
    }


    //선택한 도서 대출 기능
    @GetMapping("/loan")
    public boolean checkLoan(@RequestParam Long user_Id, @RequestParam Long book_Id){
        return loanService.checkLoanBook(user_Id, book_Id);
    }

    //대출 내역 조회 기능
    @GetMapping("/loan/user/{userId}")
    public ResponseEntity<List<LoanJoinDto>> getLoans(@PathVariable Long userId){
        return new ResponseEntity<>(loanService.getLoans(userId), HttpStatus.OK);
    }
}
