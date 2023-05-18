package com.billlog.miribojobapi.domain.member.service;

import com.billlog.miribojobapi.domain.member.dao.MemberRepository;
import com.billlog.miribojobapi.domain.member.domain.Member;
import com.billlog.miribojobapi.domain.member.dto.request.MemberDto;
import com.billlog.miribojobapi.global.custom.exception.BillLogBusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberJoinSerivce {
    private final MemberRepository memberRepository;
    private final MemberUtilService memberUtilService;

    @Transactional
    public void memberJoin(MemberDto.JoinRequest dto){
        if(memberUtilService.isDuplicateId(dto.getMemberId()))
            throw new BillLogBusinessException("중복된 아이디 입니다.");

        if(memberUtilService.isDuplicateNickname(dto.getNickname()))
            throw new BillLogBusinessException("중복된 닉네임 입니다.");

        Member member = Member.builder()
                .memberId(dto.getMemberId())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .policyAgree(dto.getPolicyAgree())
                .build();

        memberRepository.save(member);
    }
}
