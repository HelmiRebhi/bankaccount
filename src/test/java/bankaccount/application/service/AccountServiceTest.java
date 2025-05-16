package bankaccount.application.service;

import bankaccount.domain.model.Account;
import bankaccount.domain.exception.InvalidAmountException;
import bankaccount.domain.model.MockTransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private AccountService accountService;
    private Account account;
    private MockTransactionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockTransactionRepository();
        account = new Account(repository);
        accountService = new AccountService(account);
    }

    @Test
    void should_deposit_via_service() throws InvalidAmountException {
        accountService.deposit(100.0);
        assertEquals(100.0, accountService.getBalance());
    }

    @Test
    void should_fail_deposit_with_zero_amount() {
        assertThrows(InvalidAmountException.class,
                () -> accountService.deposit(0.0));
    }
}