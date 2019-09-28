package com.bs.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.test.domain.Member;


public interface MemberRepository extends JpaRepository<Member, String> {
	Member findByName(String name);

	Member findById(String id);
//	save() ���ڵ� ���� (insert, update)
//	findOne() primary key�� ���ڵ� �Ѱ� ã��
//	findAll() ��ü ���ڵ� �ҷ�����. ����(sort), ����¡(pageable) ����
//	count()	 ���ڵ� ����
//	delete()	 ���ڵ� ����
}
