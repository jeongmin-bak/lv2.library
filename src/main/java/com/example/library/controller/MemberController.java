package com.example.library.controller;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.BookResponseDto;
import com.example.library.dto.MemberRequestDto;
import com.example.library.dto.MemberResponseDto;
import com.example.library.service.BookService;
import com.example.library.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/member")
public class MemberController {

    private MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/create")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto requestDto){
        return memberService.createMember(requestDto);
    }

}
