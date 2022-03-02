package day05;

import java.nio.file.Path;
import java.util.List;

public class TransferMain {

    public static void main(String[] args) {
        TransferAggregator transferAggregator = new TransferAggregator();
        Path path = Path.of("src/main/resources/transfers.csv");
        List<TransferPerClient> summary = transferAggregator.readTransfers(path);

        for (TransferPerClient clientData : summary) {
            System.out.printf(
                "%s %,12d %5d \n",
                clientData.getClientId(), clientData.getSumOfTransactions(), clientData.getNumberOfTransaction());
        }
    }
}