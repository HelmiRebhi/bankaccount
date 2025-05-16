package bankaccount.domain.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Transaction {
    private final LocalDate date;
    private final double amount;
    private final double balance;

    public Transaction(LocalDate date, double amount, double balance) {
        this.date = Objects.requireNonNull(date, "Date cannot be null");
        this.amount = amount;
        this.balance = balance;
    }

    // Getters
    public LocalDate date() { return date; }
    public double amount() { return amount; }
    public double balance() { return balance; }
}