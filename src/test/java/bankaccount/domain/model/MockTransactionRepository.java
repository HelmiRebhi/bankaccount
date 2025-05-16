package bankaccount.domain.model;

import bankaccount.domain.exception.InvalidAmountException;
import bankaccount.domain.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;
    private MockTransactionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockTransactionRepository();
        account = new Account(repository);
    }

    @Test
    void should_deposit_amount() throws InvalidAmountException {
        account.deposit(100.0, LocalDate.now());
        assertEquals(1, repository.getTransactions().size());
        assertEquals(100.0, account.getBalance());
    }
}

// Mock pour le test
 public class MockTransactionRepository implements TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}