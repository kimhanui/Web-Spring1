package com.bs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.test.domain.Member;


public interface MemberRepository extends JpaRepository<Member, String> {
	Member findByName(String name);

	Member findById(String id);
//	save() 레코드 저장 (insert, update)
//	findOne() primary key로 레코드 한건 찾기
//	findAll() 전체 레코드 불러오기. 정렬(sort), 페이징(pageable) 가능
//	count()	 레코드 갯수
//	delete()	 레코드 삭제
}
