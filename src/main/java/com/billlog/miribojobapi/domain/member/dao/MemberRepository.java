package com.billlog.miribojobapi.domain.member.dao;

import com.billlog.miribojobapi.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByMemberId(String memberId);
    boolean existsByNickname(String nickname);
}
