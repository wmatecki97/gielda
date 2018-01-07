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
    public void run() {
        while(running)
        {
            try{
                sleep(500);
            }
            catch (Exception e){}
            buy();
            if(AdditionalFunctions.getRandom(0,10)==0) increaseBudget();
        }

    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    @Override
    protected synchronized void buy(){
        if(budget>1){
            Double price = new Double(AdditionalFunctions.getRandom(1,(int)budget,2));
            int index =AdditionalFunctions.getRandom(0,MenuFunctionality.getInvestmentFundList().size()-1);
            Purchase purchase=MenuFunctionality.buyParticipationUnits(price);
            if(purchase.getAmount()>0){
                addToPurchasesList(purchase);
                budget-=price;
            }


        }
    }

    public synchronized void display(){
        super.display();
        System.out.print("PESEL: " + PESEL + " budżet: " + budget+ "\n");
    }

    public synchronized String getOutputString(){

        String output="";

        output=PESEL+" " + budget +" "+ super.getOutputString();
        return output;
    };

    public synchronized Investor setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        Investor output = new Investor();

        output.PESEL = strArr[0];
        output.budget = Double.parseDouble(strArr[1]);
        output.setFirstName(strArr[2]);
        output.setSurname(strArr[3]);

        return output;
    }

    private synchronized void increaseBudget(){
        if(budget<2000000000)
        budget+=AdditionalFunctions.getRandom(1,1000000);
    }

    public synchronized String getPESEL() {
        return PESEL;
    }

    public synchronized void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public synchronized double getBudget() {
        return budget;
    }

    public synchronized void setBudget(double budget) {
        this.budget = budget;
    }


}
