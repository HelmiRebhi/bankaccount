package bankaccount.presentation;

import bankaccount.application.service.AccountService;
import bankaccount.application.service.StatementGenerator;
import bankaccount.domain.repository.TransactionRepository;

public class BankAccountController {
    private final AccountService accountService;
    private final StatementGenerator statementGenerator;
    private final TransactionRepository transactionRepository;

    public BankAccountController(AccountService accountService,
                                 StatementGenerator statementGenerator,
                                 TransactionRepository transactionRepository) {
        this.accountService = accountService;
        this.statementGenerator = statementGenerator;
        this.transactionRepository = transactionRepository;
    }

    public void deposit(double amount) {
        try {
            accountService.deposit(amount);
        } catch (Exception e) {
            System.err.println("Deposit error: " + e.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            accountService.withdraw(amount);
        } catch (Exception e) {
            System.err.println("Withdrawal error: " + e.getMessage());
        }
    }

    public void printStatement() {
        statementGenerator.generate(transactionRepository.findAll());
    }
}