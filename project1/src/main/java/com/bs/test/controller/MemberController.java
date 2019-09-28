package com.bs.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.test.domain.Member;
import com.bs.test.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Resource(name="memberService")
	MemberService memberService;

	// Join
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Member member) {
		memberService.register(member.getId(), member.getName(), member.getPw()); // 비즈니스 로직

		return "joinOk";
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member) {
		Member m;

		m = memberService.search(member.getId()); // 비즈니스 로직
		if (m.getPw() == member.getPw()) {
			System.out.println("Matched!");
		} else {
			System.out.println("failed");
		}
		return "loginOk";
	}

	// Cash

	// 엔티티매니저 팩토리 종료?
}
