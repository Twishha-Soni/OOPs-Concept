package com.example.bankvault;

import com.example.bankvault.exception.InsufficientFundsException;
import com.example.bankvault.exception.VaultFrozenException;
import com.example.bankvault.model.BankVault;

public class Main {

    public static void main(String[] args) {

        BankVault vault = new BankVault(1000.0);

        vault.deposit(500.0);
        vault.withdraw(200.0);

        System.out.println("Balance: " + vault.getBalance());

        //Freeze and attempt a withdraw
        vault.freeze();
        try{
            vault.withdraw(1000.0);
        } catch (VaultFrozenException e) {
            System.out.println("Blocked: " + e.getMessage());
        }

        vault.unfreeze();
        vault.withdraw(100.0);

        //try to overdraft
        try{
            vault.withdraw(9999.9);
        } catch (InsufficientFundsException e) {
            System.out.println("Blocked: " + e.getMessage());
        }

        // try to corrupt the log - this will throw UnsupportedOperationException

        try {
            vault.getTransactionLog().add("Fake Transaction");
        } catch (UnsupportedOperationException e) {
            System.out.println("Log is protected: cannot be modified from outside.");
        }

        // Print the real log
        System.out.println("\n------ Transaction Log -----");
        vault.getTransactionLog().forEach(System.out::println);
    }
}
