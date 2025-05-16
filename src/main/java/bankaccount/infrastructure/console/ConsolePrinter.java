package bankaccount.infrastructure.console;

import bankaccount.domain.port.Printer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConsolePrinter implements Printer {
    private static final String HEADER = "Date       | Amount  | Balance";
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void printHeader() {
        System.out.println(HEADER);
    }

    @Override
    public void printLine(LocalDate date, double amount, double balance) {
        System.out.printf("%s | %7.2f | %.2f%n",
                date.format(DATE_FORMATTER),
                amount,
                balance);
    }
}