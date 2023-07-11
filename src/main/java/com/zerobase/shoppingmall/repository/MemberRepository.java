package com.zerobase.shoppingmall.repository;

import com.zerobase.shoppingmall.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
