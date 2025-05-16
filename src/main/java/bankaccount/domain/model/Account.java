package bankaccount.domain.model;

import bankaccount.domain.repository.TransactionRepository;
import bankaccount.domain.exception.InsufficientFundsException;
import bankaccount.domain.exception.InvalidAmountException;

import java.time.LocalDate;

public class Account {
    private final TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(double amount, LocalDate date) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Amount must be positive");
        double newBalance = getBalance() + amount;
        transactionRepository.add(new Transaction(date, amount, newBalance));
    }

    public void withdraw(double amount, LocalDate date)
            throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException("Amount must be positive");
        if (getBalance() < amount) throw new InsufficientFundsException("Insufficient funds");
        double newBalance = getBalance() - amount;
        transactionRepository.add(new Transaction(date, -amount, newBalance));
    }

    public double getBalance() {
        return transactionRepository.findAll().stream()
                .mapToDouble(Transaction::balance)
                .max()
                .orElse(0.0);
    }
}