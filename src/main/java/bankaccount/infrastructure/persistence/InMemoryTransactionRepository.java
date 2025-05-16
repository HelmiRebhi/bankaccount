package bankaccount.infrastructure.persistence;

import bankaccount.domain.repository.TransactionRepository;
import bankaccount.domain.model.Transaction;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryTransactionRepository implements TransactionRepository {
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();

    @Override
    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return List.copyOf(transactions);
    }
}