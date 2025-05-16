package bankaccount;

import bankaccount.application.service.AccountService;
import bankaccount.application.service.StatementGenerator;
import bankaccount.domain.model.Account;
import bankaccount.domain.repository.TransactionRepository;
import bankaccount.infrastructure.console.ConsolePrinter;
import bankaccount.infrastructure.persistence.InMemoryTransactionRepository;
import bankaccount.presentation.BankAccountController;

public class App {
    public static void main(String[] args) {
        // Initialisation des dépendances
        TransactionRepository repository = new InMemoryTransactionRepository();
        Account account = new Account(repository);
        AccountService accountService = new AccountService(account);
        ConsolePrinter printer = new ConsolePrinter();
        StatementGenerator statementGenerator = new StatementGenerator(printer);

        // Création du contrôleur
        BankAccountController controller = new BankAccountController(
                accountService,
                statementGenerator,
                repository
        );

        // Exécution des opérations
        controller.deposit(1000);
        controller.deposit(2000);
        controller.withdraw(500);
        controller.printStatement();
    }
}