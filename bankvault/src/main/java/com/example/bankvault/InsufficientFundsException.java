package com.example.bankvault;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(double requested, double available) {
        super("Cannot withdraw " + requested + ". Available balance: " + available);
    }
}
