package com.bs.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bs.test.domain.Member;

@Repository
public class MemberRepository {
	@PersistenceContext
	EntityManager em;

	public void save(Member m) {
		System.out.println("member:"+m.toString());
		em.persist(m);
	}

	public Member findById(String id) {
		Member m = em.find(Member.class, id);
		return m;
	}

	public void delete(String id) {
		Member m = em.find(Member.class, id);
		em.remove(m);
	}

	public List<Member> findAll() {
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
}