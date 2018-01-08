package AllObjects.Clients;

import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import AllObjects.functionalClasses.*;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class InvestmentFund extends Client implements AllInstancess, HasName, Runnable, Serializable, HasValue, ChartItem {

    private String name;
    private double currentValue;
    private int unitsSold;
    protected List<Double> valueList;


    public InvestmentFund(){
        name = DataGenerator.getName();
        unitsSold=1;
        currentValue=AdditionalFunctions.getRandom(1,10000);
        purchaseList = new ArrayList<>();
        valueList = new ArrayList<Double>();
    }


    public synchronized Purchase buyPurchases(double price){

        double temp = price%getValue();
        price = price-temp;
        Purchase unit = new Purchase(getId(),price/getValue());
        unitsSold+=(int) price/currentValue;
        if(budget<1000000000)
            budget=budget+price;
        return unit;

    }

    @Override
    protected synchronized void work(){

        if(purchaseList.size()>0){
            double value=0.0;
            for(Purchase purchase: purchaseList){
                Goods good = (Goods)MenuFunctionality.getGood(purchase.getSubjectId());
                if(good.getClass().getSimpleName()== "RawMaterials"){
                    RawMaterials rawMaterials = (RawMaterials)good;
                    Currency cur = (Currency)MenuFunctionality.getGood(rawMaterials.getCurrencyId());
                    value+=good.getValue()*cur.getValue();
                }
                else{
                    value+=good.getValue()*purchase.getAmount();
                }
            }
            value=(value+budget)/unitsSold;
            setCurrentValue(value);
            valueList.add(value);
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


    public void setCurrentValue(double currentValue) {
        if(currentValue<0)
            System.out.println("asf");
        this.currentValue = currentValue;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized double getValue() {
        return currentValue;
    }

    @Override
    public void bought(double v) {

    }

    /**
     * deletes purchases of given object id
     * @param price
     * @param id
     */
    public synchronized void repurchase(double price, int id) {

        for(int i=0; i<purchaseList.size(); i++){
            if(purchaseList.get(i).getSubjectId()==id){
                budget+=price*purchaseList.get(i).getAmount();
                purchaseList.remove(i);
                return;
            }
        }

    }

    @Override
    public List<Double> getValueList() {
        return valueList;
    }
}
