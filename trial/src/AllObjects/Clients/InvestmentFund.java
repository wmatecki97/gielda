package AllObjects.Clients;

import AllObjects.Goods.Goods;
import AllObjects.functionalClasses.Purchase;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;
import AllObjects.functionalClasses.HasName;
import AllObjects.functionalClasses.MenuFunctionality;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class InvestmentFund extends Client implements AllInstancess, HasName, Runnable{

    private String name;
    private double currentValue;
    private int unitsSold;


    public InvestmentFund(){
        name = DataGenerator.getName();
        unitsSold=1;
        currentValue=AdditionalFunctions.getRandom(1,10000);
        purchaseList = new ArrayList<>();
    }

    public synchronized Purchase buyPurchases(double price){

        double temp = price%getCurrentValue();
        price = price-temp;
        Purchase unit = new Purchase(getId(),price/getCurrentValue());
        unitsSold+=(int) price/currentValue;
        if(budget<1000000000)
            budget=budget+price;
        return unit;

    }


    @Override
    public void run() {

        while(true)
        {
            try{
                sleep(500);
            }
            catch (Exception e){}
            buy();
            work();
        }

    }


    public synchronized void addToPurchasesList(Purchase purchase){
        purchaseList.add(purchase);
    }

    private synchronized void work(){

        if(purchaseList.size()>0){
            double value=0.0;
            for(Purchase purchase: purchaseList){
                Goods good = (Goods)MenuFunctionality.getGood(purchase.getSubjectId());
                value+=good.getValue()*purchase.getAmount();
            }
            value=(value+budget)/unitsSold;
            setCurrentValue(value);
        }
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    @Override
    protected synchronized void buy(){

        if(budget>=1)
            MenuFunctionality.buyOnRandomMarket(this ,AdditionalFunctions.getRandom(1,(int)budget,2) );
    }

    public synchronized void display(){
        super.display();
        System.out.print("nazwa: " + name +"\n");
    }

    public void setCurrentValue(double currentValue) {
        if(currentValue<0)
            System.out.println("asf");
        this.currentValue = currentValue;
    }

    public synchronized String getOutputString(){

        String output="";
        output=name +" "+ super.getOutputString();
        return output;
    };

    public synchronized InvestmentFund setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        InvestmentFund output = new InvestmentFund();

        output.name = strArr[0];
        output.setFirstName(strArr[1]);
        output.setSurname(strArr[2]);

        return output;

    };

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public double getCurrentValue() {
        return currentValue;
    }
}
