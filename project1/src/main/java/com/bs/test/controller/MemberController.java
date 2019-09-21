package com.bs.test.controller;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.test.Member;
import com.bs.test.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	//엔티티 매니저 팩토리 생성
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    
	@Resource(name="memberService")
	MemberService memberService;
	
	//Join
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join (Member member)
	{
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
	    
	    EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
            tx.begin(); //트랜잭션 시작
            memberService.register(em, member.getId(), member.getName(), member.getPw());  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

		return "joinOk";
	}
	
	//Login
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login (Member member)
	{
		Member m;
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
	    
	    EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
            tx.begin(); //트랜잭션 시작
            m = memberService.search(em, member.getId());  //비즈니스 로직
            if(m.getPw() == member.getPw()){
            	System.out.println("Matched!");
            }
            else{
            	System.out.println("failed");
            }
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

		return "loginOk";
	}
	
	//Cash
	
	
	//엔티티매니저 팩토리 종료?
}
