package bankaccount.presentation;

import bankaccount.application.service.AccountService;
import bankaccount.application.service.StatementGenerator;
import bankaccount.domain.exception.InvalidAmountException;
import bankaccount.domain.model.Account;
import bankaccount.domain.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class BankAccountControllerTest {
    @Test
    void should_handle_deposit() throws InvalidAmountException {
        // Setup
        AccountService mockService = mock(AccountService.class);
        StatementGenerator mockGenerator = mock(StatementGenerator.class);
        TransactionRepository mockRepo = mock(TransactionRepository.class);

        BankAccountController controller = new BankAccountController(
                mockService, mockGenerator, mockRepo);

        // Test
        controller.deposit(100.0);

        // Verify
        verify(mockService).deposit(100.0);
    }
}