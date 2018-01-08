package AllObjects.Clients;

import AllObjects.functionalClasses.Purchase;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;
import AllObjects.functionalClasses.MenuFunctionality;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Investor extends Client implements AllInstancess, Runnable, Serializable {
    private String PESEL;

    public Investor(){
        PESEL = DataGenerator.getPESEL();
        budget = AdditionalFunctions.getRandom(5000,1000000);
        purchaseList = new ArrayList<>();
    }

    @Override
    protected void work() {
        if(AdditionalFunctions.getRandom(0,10)==0) increaseBudget();
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    @Override
    protected synchronized void buy(){
        if(budget>1){
            Double price = new Double(AdditionalFunctions.getRandom(1,(int)budget,2));
            Purchase purchase=MenuFunctionality.buyParticipationUnits(price);
            if(purchase.getAmount()>0){
                addToPurchasesList(purchase);
                budget-=price;
            }
        }
    }

    private synchronized void increaseBudget(){
        if(budget<2000000000)
        budget+=AdditionalFunctions.getRandom(1,1000000);
    }

    public synchronized String getPESEL() {
        return PESEL;
    }

    public synchronized double getBudget() {
        return budget;
    }

    public synchronized void setBudget(double budget) {
        this.budget = budget;
    }


}
