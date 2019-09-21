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

	//��ƼƼ �Ŵ��� ���丮 ����
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    
	@Resource(name="memberService")
	MemberService memberService;
	
	//Join
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join (Member member)
	{
		EntityManager em = emf.createEntityManager(); //��ƼƼ �Ŵ��� ����
	    
	    EntityTransaction tx = em.getTransaction(); //Ʈ����� ��� ȹ��
		try {
            tx.begin(); //Ʈ����� ����
            memberService.register(em, member.getId(), member.getName(), member.getPw());  //����Ͻ� ����
            tx.commit();//Ʈ����� Ŀ��

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //Ʈ����� �ѹ�
        } finally {
            em.close(); //��ƼƼ �Ŵ��� ����
        }

		return "joinOk";
	}
	
	//Login
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login (Member member)
	{
		Member m;
		EntityManager em = emf.createEntityManager(); //��ƼƼ �Ŵ��� ����
	    
	    EntityTransaction tx = em.getTransaction(); //Ʈ����� ��� ȹ��
		try {
            tx.begin(); //Ʈ����� ����
            m = memberService.search(em, member.getId());  //����Ͻ� ����
            if(m.getPw() == member.getPw()){
            	System.out.println("Matched!");
            }
            else{
            	System.out.println("failed");
            }
            tx.commit();//Ʈ����� Ŀ��

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //Ʈ����� �ѹ�
        } finally {
            em.close(); //��ƼƼ �Ŵ��� ����
        }

		return "loginOk";
	}
	
	//Cash
	
	
	//��ƼƼ�Ŵ��� ���丮 ����?
}
