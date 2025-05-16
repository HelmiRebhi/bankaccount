package bankaccount.application.service;

import bankaccount.domain.model.Account;
import bankaccount.domain.exception.InsufficientFundsException;
import bankaccount.domain.exception.InvalidAmountException;

public class AccountService {
    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(double amount) throws InvalidAmountException {
        account.deposit(amount, java.time.LocalDate.now());
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException {
        account.withdraw(amount, java.time.LocalDate.now());
    }

    // Correction ici : utilisez getBalance() au lieu de currentBalance()
    public double getBalance() {
        return account.getBalance();
    }
}