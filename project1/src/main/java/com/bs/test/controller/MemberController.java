package com.bs.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.test.domain.Member;
import com.bs.test.service.MemberServiceImpl;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Resource(name = "memberServiceImpl")
	MemberServiceImpl service;

	// Join
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Member member) {
		service.register(member.getId(), member.getName(), member.getPw()); // 비즈니스 로직

		return "joinOk";
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member) {
		Member m = service.search(member.getId()); // 비즈니스 로직

		try {
			if (m.getPw().equals(member.getPw())) {
				System.out.println("login succeed");
			} else {
				System.out.println("login failed");
			}
		} catch (NullPointerException e) {
			System.out.println("존재하는 멤버가 아닙니다");
			e.printStackTrace();
			//return "loginFail";
		}
		return "loginOk";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<Member> members = service.searchMembers();
		if (members == null) {
			model.addAttribute("IsMember", "No");
		}
		model.addAttribute("members", members);
		return "findMembers";

	}
	// Cash

}
