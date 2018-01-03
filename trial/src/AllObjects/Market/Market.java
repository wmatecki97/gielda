package AllObjects.Market;

import AllObjects.Clients.Client;
import AllObjects.Goods.Goods;
import AllObjects.Purchases.Purchase;
import functionalClasses.AdditionalFunctions;
import functionalClasses.MenuFunctionality;

import java.util.List;

public class Market {

    protected List<Goods> goodsList;
    protected double markup;

    public Market(){
        markup = (double) AdditionalFunctions.getRandom(1,300)/1000;
    }

    public synchronized void buy(Client client, double cost){
        Goods subject = getRandomGood();
        buy(client, subject, cost);
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    protected synchronized void buy(Client client, Goods subject, double cost){//can not be synchronised

        double markupValue = cost*markup;
        cost = cost-markupValue;
        Purchase purchase = new Purchase(client.getId(), subject.getId(), cost/subject.getValue());


        double budget = client.getBudget();

        client.setBudget(budget-cost-markupValue);

        MenuFunctionality.getPurchasesList().addToList(purchase);

        System.out.println(purchase.getClientId() + " "+ purchase.getSellerId());

    }

    protected synchronized Goods getRandomGood(){
        return (Goods)goodsList.get(AdditionalFunctions.getRandom(0,goodsList.size()-1));
    }

}
