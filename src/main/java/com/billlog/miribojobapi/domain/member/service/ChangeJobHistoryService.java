package com.billlog.miribojobapi.domain.member.service;

import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyAddress;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyInfo;
import com.billlog.miribojobapi.domain.common.domain.constant.MemberCompanyWorkTimeInfo;
import com.billlog.miribojobapi.domain.member.dao.ChangeJobHistoryRepository;
import com.billlog.miribojobapi.domain.member.dao.MemberRepository;
import com.billlog.miribojobapi.domain.member.domain.ChangeJobHistory;
import com.billlog.miribojobapi.domain.member.dto.request.ChangeJobHistoryDto;
import com.billlog.miribojobapi.domain.member.dto.response.ChangeJobHistoryResponseDto;
import com.billlog.miribojobapi.global.utils.CurrentLoginUserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChangeJobHistoryService {
    private final ChangeJobHistoryRepository changeJobHistoryRepository;
    private final MemberRepository memberRepository;
    private final CurrentLoginUserUtil currentLoginUserUtil;

    @Transactional
    public void addChangeJobHistory(ChangeJobHistoryDto.addHistoryRequest dto) {
        Long memberNo = currentLoginUserUtil.getMemberNoByLoginUser();
        ChangeJobHistory changeJobHistory = ChangeJobHistory.builder()
                .memberCompanyInfo(new MemberCompanyInfo(dto.getCompanyName(), dto.getCompanyRgstNo()))
                .memberCompanyAddress(new MemberCompanyAddress(dto.getSidoName(), dto.getSigoonguName()))
                .memberCompanyWorkTimeInfo(new MemberCompanyWorkTimeInfo(dto.getWorkingStartDate(), dto.getWorkingEndDate()))
                .position(dto.getPosition())
                .member(memberRepository.getReferenceById(memberNo))
                .build();

        changeJobHistoryRepository.save(changeJobHistory);
    }

    @Transactional(readOnly = true)
    public List<ChangeJobHistoryResponseDto> getChangeJobHistoryList(Long memberNo){
        return changeJobHistoryRepository.findAllByMember_MemberNo(memberNo)
                .stream()
                .map(ChangeJobHistoryResponseDto::new)
                .collect(Collectors.toList());
    }

}
