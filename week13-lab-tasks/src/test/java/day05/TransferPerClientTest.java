package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransferPerClientTest {

    TransferPerClient transferPerClient;

    @BeforeEach
    void setUp() {
        transferPerClient = new TransferPerClient("AA11");
    }

    @Test
    void getClientIdTest() {
        assertEquals("AA11", transferPerClient.getClientId());
    }

    @Test
    void getSumOfTransactionsTest() {
        assertEquals(0, transferPerClient.getSumOfTransactions());
    }

    @Test
    void getNumberOfTransactionTest() {
        assertEquals(0, transferPerClient.getNumberOfTransaction());
    }

    @Test
    void increaseSumTest() {
        transferPerClient.increaseSum(1000);
        assertEquals(1, transferPerClient.getNumberOfTransaction());
        assertEquals(1000, transferPerClient.getSumOfTransactions());
    }

    @Test
    void decreaseSumTest() {
        transferPerClient.decreaseSum(1000);
        assertEquals(1, transferPerClient.getNumberOfTransaction());
        assertEquals(-1000, transferPerClient.getSumOfTransactions());
    }

    @Test
    void testToStringTest() {
        transferPerClient.increaseSum(1000);
        assertEquals("AA11 1000 1", transferPerClient.toString());
    }
}