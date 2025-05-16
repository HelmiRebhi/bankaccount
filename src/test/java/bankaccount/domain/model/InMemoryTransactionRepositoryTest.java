package bankaccount.domain.model;


import bankaccount.domain.repository.TransactionRepository;
import bankaccount.infrastructure.persistence.InMemoryTransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTransactionRepositoryTest {
    private TransactionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryTransactionRepository();
    }

    @Test
    void should_add_and_retrieve_transactions() {
        Transaction t1 = new Transaction(LocalDate.now(), 100.0, 100.0);
        Transaction t2 = new Transaction(LocalDate.now(), 50.0, 150.0);

        repository.add(t1);
        repository.add(t2);

        List<Transaction> transactions = repository.findAll();
        assertEquals(2, transactions.size());
        assertEquals(150.0, transactions.get(1).balance());
    }
}