package com.sbn.rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbn.rest.domain.entity.AmpsTransaction;

public interface AmpsTransactionRepository extends JpaRepository<AmpsTransaction, Long> {

}
