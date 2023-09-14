package com.rodcollab.ckeeapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CkeeAppApplication {

    public static final Logger log = LoggerFactory.getLogger(CkeeAppApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CkeeAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TransactionRepository repository) {
        return args -> {

            repository.save(new Transaction("10-01-2023","OUTCOME","Beach Tennis", "CARD", "ENTERTAINMENT", 50.0));
            repository.save(new Transaction("15-02-2023", "OUTCOME", "Movie Night", "PIX", "ENTERTAINMENT", 65.0));
            repository.save(new Transaction("20-02-2023", "INCOME", "Monthly Salary", "BANKSLIP", "SALARY", 2800.0));
            repository.save(new Transaction("05-03-2023", "OUTCOME", "Online Shopping", "CARD", "SHOPPING", 150.5));
            repository.save(new Transaction("10-03-2023", "OUTCOME", "Dinner with Friends", "CASH", "ENTERTAINMENT", 75.25));
            repository.save(new Transaction("25-03-2023", "INCOME", "Investment Dividend", "BANKSLIP", "INVESTMENT", 800.0));
            repository.save(new Transaction("02-04-2023", "OUTCOME", "Gym Membership", "CARD", "ENTERTAINMENT", 90.0));
            repository.save(new Transaction("12-04-2023", "INCOME", "Freelance Income", "PIX", "INCOME", 450.0));
            repository.save(new Transaction("18-04-2023", "OUTCOME", "Grocery Shopping", "CASH", "SHOPPING", 120.75));
            repository.save(new Transaction("30-04-2023", "OUTCOME", "Concert Tickets", "CARD", "ENTERTAINMENT", 200.0));
            repository.save(new Transaction("05-05-2023", "INCOME", "Stock Dividend", "BANKSLIP", "INVESTMENT", 350.0));

            log.info("Transactions found with findAll():");
            log.info("-------------------------------");
            for (Transaction transaction : repository.findAll()) {
                log.info(transaction.toString());
            }
            log.info("");

            Transaction transaction = repository.
                    findById(1L);
            log.info("Transaction found with findById(1L):");
            log.info("--------------------------------");
            log.info(transaction.toString());
            log.info("");

            log.info("Transaction found with findByCreatedAt('18/04/2023'):");
            log.info("--------------------------------------------");
            repository.findByCreatedAt("18-04-2023").forEach(date -> {
                log.info(date.toString());
            });

            log.info("");
        };
    }




}

