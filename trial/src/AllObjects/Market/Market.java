package AllObjects.Market;

import AllObjects.Clients.InvestmentFund;
import AllObjects.Goods.Goods;
import AllObjects.functionalClasses.Purchase;
import AllObjects.functionalClasses.AdditionalFunctions;

import java.io.Serializable;
import java.util.List;

public class Market implements Serializable{

    protected List<Goods> goodsList;
    protected double markup;

    public Market(){
        markup = (double) AdditionalFunctions.getRandom(1,300)/1000;
    }

    public synchronized void buy(InvestmentFund client, double cost){
        Goods subject;
        synchronized (subject = getRandomGood()){
            buy(client, subject, cost);
        }
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    protected synchronized void buy(InvestmentFund client, Goods subject, double cost){//can not be synchronised

        double markupValue = cost*markup;
        cost = cost-markupValue;
        Purchase purchase = new Purchase(subject.getId(), cost/subject.getValue());

        double budget = client.getBudget();

//        client.setBudget(budget-cost-markupValue);

//        client.addToPurchasesList(purchase);

        //System.out.println(purchase.getClientId() + " "+ purchase.getSubjectId());

    }

    public synchronized Goods getRandomGood(){
        return (Goods)goodsList.get(AdditionalFunctions.getRandom(0,goodsList.size()-1));
    }

}
