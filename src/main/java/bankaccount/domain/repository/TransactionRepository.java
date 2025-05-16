package bankaccount.domain.repository;

import bankaccount.domain.model.Transaction;
import java.util.List;

public interface TransactionRepository {
    void add(Transaction transaction);
    List<Transaction> findAll();
}