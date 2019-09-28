package com.bs.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.test.domain.Member;
import com.bs.test.repository.MemberRepository;

@Service("memberService")
public class MemberService implements IMemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void register(String id, String name, String pw) {

		Member m = new Member();
		m.setId(id);
		m.setName(name);
		m.setPw(pw);
		m.setWashers(null);
		m.setCash(0);
		memberRepository.save(m);

		System.out.println("registered : " + m.toString());
	}

	@Override
	public Member search(String id) {
		Member m = memberRepository.findById(id);
		return m;
	}

	@Override
	public void modify(String bfr_id, String aft_id, String aft_name, String aft_pw) {
		Member m = memberRepository.findById(bfr_id);
		System.out.println("modify - before : " + m.toString());
		m.setId(aft_id);
		m.setName(aft_name);
		m.setPw(aft_pw);

		System.out.println("modify - after : " + m.toString());
	}

	@Override
	public void remove(String id) {
		Member m = memberRepository.findById(id);
		System.out.println("remove : " + m.toString());
		memberRepository.delete(m);
	}

	@Override
	public void recharge(String id, int cash) {
		Member m = memberRepository.findById(id);
		System.out.println("recharge : " + m.getCash() + " -> ");
		m.setCash(cash);
		System.out.println(m.getCash());
	}
}
