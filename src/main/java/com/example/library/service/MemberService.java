package com.example.library.service;

import com.example.library.dto.BookRequestDto;
import com.example.library.dto.MemberRequestDto;
import com.example.library.dto.MemberResponseDto;
import com.example.library.entity.Member;
import com.example.library.repository.BookRepository;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public MemberResponseDto createMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto);
        return new MemberResponseDto(memberRepository.save(member));
    }
}
