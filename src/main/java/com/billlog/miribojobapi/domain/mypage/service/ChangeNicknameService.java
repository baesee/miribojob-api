package com.billlog.miribojobapi.domain.mypage.service;

import com.billlog.miribojobapi.domain.member.dao.MemberRepository;
import com.billlog.miribojobapi.domain.member.domain.Member;
import com.billlog.miribojobapi.domain.member.service.MemberUtilService;
import com.billlog.miribojobapi.domain.mypage.dto.request.MyInfoDto;
import com.billlog.miribojobapi.global.custom.exception.BillLogBusinessException;
import com.billlog.miribojobapi.global.utils.CurrentLoginUserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ChangeNicknameService {
    private final MemberRepository memberRepository;
    private final CurrentLoginUserUtil currentLoginUserUtil;
    private final MemberUtilService memberUtilService;

    public void setChangeNickname(MyInfoDto.nicknameChangeRequest dto) {
        Long memberNo = currentLoginUserUtil.getMemberNoByLoginUser();

        Member member = memberRepository.findById(memberNo)
                .orElseThrow(() -> new NoSuchElementException("가입되지 않은 회원정보입니다."));

        if(memberUtilService.isDuplicateNickname(dto.getNickName()))
            throw new BillLogBusinessException("중복된 닉네임 입니다.");

        member.changeNickname(dto.getNickName());

    }

}
