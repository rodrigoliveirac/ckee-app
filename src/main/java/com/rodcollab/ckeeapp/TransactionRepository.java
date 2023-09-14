package com.rodcollab.ckeeapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByCreatedAt(String createdAt);

    Transaction findById(long id);
}
