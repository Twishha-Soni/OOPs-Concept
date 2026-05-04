package com.example.bankvault;

public class VaultFrozenException extends RuntimeException {

    public VaultFrozenException() {
        super("Vault is frozen. No withdrawals are permitted.");
    }
}
