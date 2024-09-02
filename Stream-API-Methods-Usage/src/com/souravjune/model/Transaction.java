package com.souravjune.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Transaction {
    private int id;
    private String description;
    private double amount;
    private LocalDate transactionDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Transaction(int id, String description, double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static List<Transaction> getTransactions() {
        return Arrays.asList(
                new Transaction(1, "Payment to Supplier", 1500.0),
                new Transaction(2, "Refund", 1200.0),
                new Transaction(3, "Purchase", 1100.0),
                new Transaction(4, "Consulting Fee", 2000.0)
        );
    }
}

