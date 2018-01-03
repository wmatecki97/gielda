package AllObjects.Goods;

import AllObjects.Client;
import AllObjects.Purchase;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;

import java.util.ArrayList;
import java.util.List;

public class Goods implements AllInstancess {

    protected List<Purchase> ownerList;
    protected double value;
    protected  String name;

    public synchronized String getName() {
        return name;
    }

    public Goods()
    {
        value = AdditionalFunctions.getRandom(1,2000,2);
        ownerList = new ArrayList<>();
    }

    private synchronized void addToOwnerList(Purchase purchase)
    {
        ownerList.add(purchase);
    }

    public synchronized boolean checkIfIsEnough(double cost){

        return true;

    }

    public synchronized List<Purchase> getOwnerList() {
        return ownerList;
    }

    public synchronized void setOwnerList(List<Purchase> ownerList) {
        this.ownerList = ownerList;
    }

    public synchronized void setValue(double value) {
        this.value = value;
    }

    public synchronized double getValue() {
        return value;
    }

    public synchronized void buy(double price, Client client, double markup){

        boolean a = checkIfIsEnough(price-price*markup);
        if(checkIfIsEnough(price-price*markup)==false)

        {
            Company temp =(Company)this;
            double amounnt = temp.getActionsLeft();
            price = amounnt*value/(1-markup);
        }

        double markupValue = price*markup;
        price = price-markupValue;

        Purchase purchase = new Purchase();
        purchase.setAmount(price*this.value);
        purchase.setId(client.getId());

        client.setBudget(client.getBudget()-price-markupValue);

        addToOwnerList(purchase);

        System.out.println(purchase.getId());
    }

    @Override
    public synchronized String getOutputString() {
        return null;
    }

    @Override
    public synchronized AllInstancess setValues(String a) {
        return null;
    }

    @Override
    public synchronized void display() {

    }
}
