package com.bs.test.service;

import javax.persistence.EntityManager;

import com.bs.test.domain.Member;
import com.bs.test.domain.Washer;
import com.bs.test.domain.WasherStatus;

public interface IWasherService {
	void washerRegister(EntityManager em, Long id, WasherStatus washerstatus);
	Washer washerSearch(EntityManager em, Long id);
	void washerModify(EntityManager em, Long bfr_id, Long aft_id, WasherStatus aft_washerstatus, Member aft_member);
	void washerRemove(EntityManager em, Long id);
}
