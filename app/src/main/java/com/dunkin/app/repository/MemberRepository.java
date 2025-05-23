package com.dunkin.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dunkin.app.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	//찾을 경우 find, 존재유무 exists쓰기. 뒤에는 By필드명 기술
	Optional<Member> findById(String id); //로그인 체크용: select * from member where id=?
	boolean existsById(String id); //중복 체크용 boolean (select * from member where id=?)
	Optional<Member> findByNo(Long no);
	
}
