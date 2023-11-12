package com.example.library.controller;

import com.example.library.dto.MemberRequestDto;
import com.example.library.dto.MemberResponseDto;
import com.example.library.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    //도서관 회원 등록 기능
    @PostMapping("/create")
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberRequestDto requestDto){
        return new ResponseEntity<>(memberService.createMember(requestDto), HttpStatus.OK);
    }

}
