package com.rodcollab.ckeeapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TransactionsController {

    private static final String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    private final TransactionRepository repository;


    TransactionsController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions() {
        return repository.findAll();
    }

    @GetMapping("/transactions/{id}")
    Transaction findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
    }

    @GetMapping("/transactions/createdAt")
    List<Transaction> findByCreatedAt(@RequestParam(value = "date") String createdAt) {
        return repository.findByCreatedAt(createdAt);
    }

    @PostMapping("/addTransaction")
    Transaction newTransaction(@RequestBody Transaction newTransaction) {
        return repository.save(newTransaction);
    }

    @PutMapping("/transactions/{id}")
    Transaction replaceTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {
        return repository.findById(id)
                .map(transaction -> {
                    transaction.setDescription(transaction.getDescription());
                    transaction.setType(transaction.getType());
                    transaction.setPaymentMethod(transaction.getPaymentMethod());
                    transaction.setCategory(transaction.getCategory());
                    transaction.setAmount(transaction.getAmount());
                    return repository.save(transaction);
                })
                .orElseGet(() -> {
                    newTransaction.setId(id);
                    return repository.save(newTransaction);
                });
    }

    @DeleteMapping("/transactions/{id}")
    void deleteTransaction(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @DeleteMapping("/transactions/deleteAll")
    void deleteAllTransactions() {
        repository.deleteAll();
    }

}

class TransactionNotFoundException extends RuntimeException {

    TransactionNotFoundException(Long id) {
        super("Could not find transaction " + id);
    }
}