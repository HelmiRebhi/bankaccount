package bankaccount.domain.port;

import bankaccount.domain.model.Transaction;

import java.util.List;

public interface TransactionRepositoryPort {
    void add(Transaction transaction);
    List<Transaction> findAll();
}