package com.bs.test.service;

import com.bs.test.domain.Member;

public interface IMemberService {
	void register( String id, String name, String pw);
	Member search( String id);
	void modify( String bfr_id, String aft_id, String aft_name, String aft_pw);
	void remove(String id);
	void recharge( String id, int cash );
}
