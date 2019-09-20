package com.bs.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Washer {

	@Id @GeneratedValue
	@Column(name="WASHER_ID")
	private Long id;
	
	private WasherStatus washerStatus;
	
	@ManyToOne
	@JoinColumn(name="MEMBER")
	private Member member;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public WasherStatus getWasherStatus() {
		return washerStatus;
	}

	public void setWasherStatus(WasherStatus washerStatus) {
		this.washerStatus = washerStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	
}
