package bankaccount.application.service;

import bankaccount.domain.model.Transaction;
import bankaccount.domain.port.Printer;

import java.util.List;

public class StatementGenerator {
    private final Printer printer;

    public StatementGenerator(Printer printer) {
        this.printer = printer;
    }

    public void generate(List<Transaction> transactions) {
        printer.printHeader();
        transactions.forEach(t -> printer.printLine(
                t.date(),
                t.amount(),
                t.balance()
        ));
    }
}