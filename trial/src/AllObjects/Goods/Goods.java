package AllObjects.Goods;

import AllObjects.AllPurchases;
import AllObjects.Client;
import AllObjects.Purchase;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.MenuFunctionality;

import java.util.ArrayList;
import java.util.List;

public class Goods implements AllInstancess {

    protected double value;
    protected  String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public synchronized String getName() {
        return name;
    }

    public Goods(){
        value = AdditionalFunctions.getRandom(1,2000,2);
        id = AdditionalFunctions.getUniqueIndex();
    }


    public synchronized boolean checkIfIsEnough(double cost){

        return true;

    }

    public synchronized void setValue(double value) {
        this.value = value;
    }

    public synchronized double getValue() {
        return value;
    }

    public synchronized void buy(double price, Client client, double markup){

        boolean a = checkIfIsEnough(price-price*markup);
        if(checkIfIsEnough(price-price*markup)==false){
            Company temp =(Company)this;
            double amounnt = temp.getActionsLeft();
            price = amounnt*value/(1-markup);
        }

        double markupValue = price*markup;
        price = price-markupValue;

        Purchase purchase = new Purchase(client.getId(), id, price*this.value);

        client.setBudget(client.getBudget()-price-markupValue);

        AllPurchases purchasesList =  MenuFunctionality.getPurchasesList();
        purchasesList.addToList(purchase);

        System.out.println(purchase.getClientId() + " "+ purchase.getSellerId());
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
