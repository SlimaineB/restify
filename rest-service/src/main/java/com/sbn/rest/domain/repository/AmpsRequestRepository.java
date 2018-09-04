package com.sbn.rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbn.rest.domain.entity.AmpsRequest;

public interface AmpsRequestRepository extends JpaRepository<AmpsRequest, Long> {
	
	public AmpsRequest findByName(String name);

}
