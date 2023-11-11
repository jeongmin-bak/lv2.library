package com.example.library.controller;

import com.example.library.dto.LoanRequestDto;
import com.example.library.dto.LoanResponseDto;
import com.example.library.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PutMapping("/return/{bookId}")
    public Long returnBook(@PathVariable Long bookId, @RequestBody LoanRequestDto requestDto){
        return loanService.returnBook(bookId,requestDto);
    }

    @GetMapping("/loan/{userId}")
    public List<LoanResponseDto> getLoans(@PathVariable Long userId){
        return loanService.getLoans(userId);
    }
}
