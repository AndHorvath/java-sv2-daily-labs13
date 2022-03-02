package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferAggregatorTest {

    TransferAggregator transferAggregator;
    Path path;
    Throwable exception;

    @BeforeEach
    void setUp() {
        transferAggregator = new TransferAggregator();
        path = Path.of("src/test/resources/transfers.csv");
    }

    @Test
    void readTransfersTest() {
        List<TransferPerClient> summary = transferAggregator.readTransfers(path);

        assertEquals(20, summary.size());
        assertEquals("067d6428-d42e-47fa-b427-1213737105ae", summary.get(0).getClientId());
        assertEquals(7_493_941, summary.get(0).getSumOfTransactions());
        assertEquals(113, summary.get(0).getNumberOfTransaction());

        int overallSumOfTransactions = 0;
        int overallNumberTransactions = 0;
        for (TransferPerClient clientData : summary) {
            overallSumOfTransactions += clientData.getSumOfTransactions();
            overallNumberTransactions += clientData.getNumberOfTransaction();
        }
        assertEquals(0, overallSumOfTransactions);
        assertEquals(2000, overallNumberTransactions);

        exception = assertThrows(
            IllegalStateException.class,
            () -> transferAggregator.readTransfers(Path.of("src/test/resources/transfers_.csv"))
        );
        assertEquals("Cannot read file.", exception.getMessage());
    }
}