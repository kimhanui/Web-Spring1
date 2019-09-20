package com.bs.test;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {

	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private String id;
	
	private String name;
	private String pw;
	private int cash;
	
	@OneToMany(mappedBy="member")
	private List<Washer> washers;
	
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
