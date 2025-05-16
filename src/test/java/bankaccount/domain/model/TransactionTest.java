package bankaccount.domain.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    @Test
    void should_create_valid_transaction() {
        Transaction transaction = new Transaction(LocalDate.now(), 100.0, 100.0);
        assertEquals(100.0, transaction.amount());
        assertEquals(100.0, transaction.balance());
    }

    @Test
    void should_throw_when_null_date() {
        assertThrows(NullPointerException.class,
                () -> new Transaction(null, 100.0, 100.0));
    }
}