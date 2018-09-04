package com.sbn.rest.domain.listener;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.sbn.rest.domain.entity.AmpsTransaction;
import com.sbn.rest.domain.entity.Auditable;
import com.sbn.rest.util.BeanUtil;

public class AuditEntityListener {

	@PrePersist
	public void prePersist(Auditable target) {
		perform(target, "INSERTED");
		System.out.println("prePersist" + target.toString());
	}

	@PreUpdate
	public void preUpdate(Auditable target) {
		// perform(target, "UPDATED");
	}

	@PreRemove
	public void preRemove(Auditable target) {
		// perform(target, "DELETED");
	}

	@Transactional(value = TxType.MANDATORY)
	private void perform(Auditable target, String action) {
		System.out.println();
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
		entityManager.persist(new AmpsTransaction());
	}

}
