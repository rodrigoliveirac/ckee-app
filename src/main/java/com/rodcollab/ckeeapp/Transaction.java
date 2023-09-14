package com.rodcollab.ckeeapp;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String createdAt;
    private String type;
    private String description;
    private String paymentMethod;
    private String category;
    private Double amount;

    protected Transaction() {

    }
    Transaction(String createdAt, String type, String description, String paymentMethod, String category, Double amount) {
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format(
                "Transaction[id=%d, createdAt='%s', type='%s', description='%s', paymentMethod='%s', category='%s', amount='%s']",
                id, createdAt, type, description, paymentMethod, category, amount);
    }

    public Long getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String type() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCategory() {
        return category;
    }

    public Double getAmount() {
        return amount;
    }
}
