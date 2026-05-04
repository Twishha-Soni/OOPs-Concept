package com.example.bankvault.model;

import com.example.bankvault.exception.InsufficientFundsException;
import com.example.bankvault.exception.VaultFrozenException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankVault {

    // No setter exists for any of these fields.
    // The only  way to change them is through the vault's own methods.

    private double balance;
    private boolean frozen;
    private final List<String> transactionLog = new ArrayList<>();

    public BankVault(double initialBalance) {
        if(initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
        transactionLog.add("Vault created with balance: " + initialBalance);
    }

    // Enforced Operations
    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactionLog.add("DEPOSIT : +" + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) {
        if(frozen) {
            throw new VaultFrozenException();
        }
        if(amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if(amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
        transactionLog.add("WITHDRAWAL: -" + amount + " | Balance:" + balance);
    }

    public void freeze() {
        frozen = true;
        transactionLog.add("Vault FROZEN.");
    }

    public void unfreeze() {
        frozen = false;
        transactionLog.add("Vault UNFROZEN.");
    }

    // Read-only access
    public double getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    // The caller gets a view - not the real list.
    // They cannot add, remove or clear the log from outside.
    public List<String> getTransactionLog() {
        return Collections.unmodifiableList(transactionLog);
    }
}


