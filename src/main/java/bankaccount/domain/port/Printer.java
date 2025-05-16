package bankaccount.domain.port;

import java.time.LocalDate;

public interface Printer {
    void printHeader();
    void printLine(LocalDate date, double amount, double balance);
}