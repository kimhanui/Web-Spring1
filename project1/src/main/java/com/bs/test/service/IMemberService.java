package com.bs.test.service;

import javax.persistence.EntityManager;

import com.bs.test.Member;

public interface IMemberService {
	void register(EntityManager em, String id, String name, String pw);
	Member search(EntityManager em, String id);
	void modify(EntityManager em, String bfr_id, String aft_id, String aft_name, String aft_pw);
	void remove(EntityManager em, String id);
	void recharge(EntityManager em, String id, int cash );
}
