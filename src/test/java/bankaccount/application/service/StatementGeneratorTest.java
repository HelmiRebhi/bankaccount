package bankaccount.application.service;

import bankaccount.domain.model.Transaction;
import bankaccount.domain.port.Printer;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

class StatementGeneratorTest {
    @Test
    void should_generate_statement_correctly() {
        // Given
        Printer mockPrinter = mock(Printer.class);
        StatementGenerator generator = new StatementGenerator(mockPrinter);
        List<Transaction> transactions = List.of(
                new Transaction(LocalDate.of(2023, 1, 1), 100.0, 100.0),
                new Transaction(LocalDate.of(2023, 1, 2), -50.0, 50.0)
        );

        // When
        generator.generate(transactions);

        // Then
        verify(mockPrinter).printHeader();
        verify(mockPrinter).printLine(LocalDate.of(2023, 1, 1), 100.0, 100.0);
        verify(mockPrinter).printLine(LocalDate.of(2023, 1, 2), -50.0, 50.0);
    }
}