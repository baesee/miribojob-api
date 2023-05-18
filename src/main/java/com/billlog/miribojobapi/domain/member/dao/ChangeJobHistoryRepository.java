package com.billlog.miribojobapi.domain.member.dao;

import com.billlog.miribojobapi.domain.member.domain.ChangeJobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeJobHistoryRepository extends JpaRepository<ChangeJobHistory, Long> {
    List<ChangeJobHistory> findAllByMember_MemberNo(Long MemberNo);
}
