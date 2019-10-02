package com.bs.test.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {

	@Id
	@Column(name="MEMBER_ID")
	private String id;
	
	@Column(name="NAME")
	private String name;
	@Column(name="PW")
	private String pw;
	@Column(name="CASH")
	private int cash;
	
	@OneToMany(mappedBy="member", cascade = CascadeType.ALL)
	private List<Washer> washers = new ArrayList<Washer>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public List<Washer> getWashers() {
		return washers;
	}
	public void setWashers(List<Washer> washers) {
		this.washers = washers;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public String toString() {
		return "Member[id="+getId()+", pw="+getPw()+", name="+getName()+", washers="+getWashers()+", cash="+getCash()+"]";
	}
}
