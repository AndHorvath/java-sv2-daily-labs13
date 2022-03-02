package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TransferAggregator {

    // --- public methods -----------------------------------------------------

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> lines = readLines(path);
        return summarizeLines(lines);
    }

    // --- private methods ----------------------------------------------------

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file.", exception);
        }
    }

    private List<TransferPerClient> summarizeLines(List<String> lines) {
        Map<String, TransferPerClient> summary = new TreeMap<>();
        for (String line : lines) {
            String[] fields = line.split(",");
            String payer = fields[0];
            String payee = fields[1];
            int amount = Integer.parseInt(fields[2]);

            updateClientData(payer, summary, amount, true);
            updateClientData(payee, summary, amount, false);
        }
        return new ArrayList<>(summary.values());
    }

    private void updateClientData(
        String client, Map<String, TransferPerClient> summary, int amount, boolean isPayer) {

        TransferPerClient clientData = summary.computeIfAbsent(client, key -> new TransferPerClient(client));
        if (isPayer) {
            clientData.decreaseSum(amount);
        } else {
            clientData.increaseSum(amount);
        }
    }
}