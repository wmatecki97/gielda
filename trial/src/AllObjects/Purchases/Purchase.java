package AllObjects.Purchases;

public class Purchase {

    private int clientId;
    private double amount;
    private int sellerId;

    public Purchase(int clientId, int sellerId, double amount){

        setClientId(clientId);
        setSellerId(sellerId);
        setAmount(amount);

    }

    public synchronized int getClientId() {
        return clientId;
    }

    public synchronized void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public synchronized int getSellerId() {
        return sellerId;
    }

    public synchronized void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public synchronized double getAmount() {
        return amount;
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }
}
