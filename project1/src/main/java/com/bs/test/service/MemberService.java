package com.bs.test.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.bs.test.Member;

@Service
public class MemberService implements IMemberService {
	
	@Override
	public void register(EntityManager em, String id, String name, String pw) {
		Member m = new Member();
		m.setId(id);
		m.setName(name);
		m.setPw(pw);
		m.setWashers(null);
		m.setCash(0);
		em.persist(m);
	}
	
	@Override
	public Member search(EntityManager em, String id) {
		Member m = em.find(Member.class, id);
		return m;
	}
	
	@Override
	public void modify(EntityManager em, String bfr_id, String aft_id, String aft_name, String aft_pw) {
		Member m = em.find(Member.class, bfr_id);
		System.out.println("");
		m.setId(aft_id);
		m.setName(aft_name);
		m.setPw(aft_pw);
		
		//Ãâ·Â before,after
	}
	
	@Override
	public void remove(EntityManager em, String id){
		Member m = em.find(Member.class, id);
		em.remove(m);
	}
	
	@Override
	public void recharge(EntityManager em, String id, int cash ) {
		Member m = em.find(Member.class, id);
		m.setCash(cash);
	}
}
