package com.rodcollab.ckeeapp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    List<Transaction> findByCreatedAt(String createdAt);

    Transaction findById(long id);
}
