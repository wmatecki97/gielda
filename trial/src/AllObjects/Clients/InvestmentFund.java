package AllObjects.Clients;

import AllObjects.Purchases.AllPurchases;
import AllObjects.Purchases.Purchase;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.DataGenerator.DataGenerator;
import functionalClasses.MenuFunctionality;

import java.util.List;

import static java.lang.Thread.sleep;

public class InvestmentFund extends Client implements AllInstancess, Runnable{

    private String name;
    private double currentValue;
    private int unitsSold;

    public InvestmentFund(){
        name = DataGenerator.getName();
        unitsSold=0;
        currentValue=AdditionalFunctions.getRandom(1,10000);
        Thread t = new Thread(this);
        t.start();
    }

    public synchronized void buyParticipationUnits(double price){

        unitsSold+=(int)price/currentValue;
        budget=budget+price;

    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public void run() {

        while(true)
        {
            try{
                sleep(5000);
            }
            catch (Exception e){}
            buy();
            List<Purchase> list = AllPurchases.getBoughtProducts(getId());
            if(list.size()>0){
                double value=0.0;
                for(Purchase purchase: list){

                    value+=MenuFunctionality.getValueOfGood(purchase.getSellerId());


                }
                value=value/unitsSold;
                setCurrentValue(value);
            }
        }

    }

    public synchronized void display(){
        super.display();
        System.out.print("nazwa: " + name +"\n");
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
