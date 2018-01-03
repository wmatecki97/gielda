package AllObjects;

public class Purchase {

    private int clientId;
    private double amount;
    private int sellerId;

    public Purchase(int clientId, int sellerId, double amount){

        setClientId(clientId);
        setSellerId(sellerId);
        setAmount(amount);

    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
