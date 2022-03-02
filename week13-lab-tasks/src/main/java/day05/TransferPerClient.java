package day05;

public class TransferPerClient {

    // --- attributes ---------------------------------------------------------

    private String clientId;
    private int sumOfTransactions;
    private int numberOfTransaction;

    // --- constructors -------------------------------------------------------

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
    }

    // --- getters and setters ------------------------------------------------

    public String getClientId() { return clientId; }
    public int getSumOfTransactions() { return sumOfTransactions; }
    public int getNumberOfTransaction() { return numberOfTransaction; }

    // --- public methods -----------------------------------------------------

    public void increaseSum(int amount) {
        sumOfTransactions += amount;
        numberOfTransaction += 1;
    }

    public void decreaseSum(int amount) {
        increaseSum(amount * (-1));
    }

    @Override
    public String toString() {
        return clientId + " " + sumOfTransactions + " " + numberOfTransaction;
    }
}