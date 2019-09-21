package com.bs.test.service;

import javax.persistence.EntityManager;

import com.bs.test.Member;
import com.bs.test.Washer;
import com.bs.test.WasherStatus;

public class WasherService implements IWasherService {
	@Override
	public void washerRegister(EntityManager em, Long id, WasherStatus washerstatus) {
		Washer w = new Washer();
		w.setId(id);
		w.setWasherStatus(washerstatus);
		w.setMember(null);
		em.persist(w);
	}
	
	@Override
	public Washer washerSearch(EntityManager em, Long id) {
		Washer w = em.find(Washer.class, id);
		return w;
	}
	
	@Override
	public void washerModify(EntityManager em, Long bfr_id, Long aft_id, WasherStatus aft_washerstatus, Member aft_member) {
		Washer w = em.find(Washer.class, bfr_id);
		w.setId(aft_id);
		w.setMember(aft_member);
		w.setWasherStatus(aft_washerstatus);
	}
	
	@Override
	public void washerRemove(EntityManager em, Long id) {
		Washer w = em.find(Washer.class, id);
		em.remove(w);
	}
}
