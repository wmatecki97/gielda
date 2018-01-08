package AllObjects.Goods;


import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import static AllObjects.functionalClasses.AdditionalFunctions.getRandom;

public class Company extends Goods implements Runnable, Serializable{

    private Date date;
    /**
     * minimum value
     */
    private double min;
    /**
     * maximum value
     */
    private double max;
    private int numberOfActions;
    /**
     * action which are not sol
     */
    private int actionsLeft;
    private double openingValue;
    private double profit;
    private double income;
    private double individualCapital;
    private double factoryCapital;
    private int volume;
    private double turnover;

    public Company(){
        setName(DataGenerator.getName());
        setDate(DataGenerator.getDate());
        setOpeningValue(getRandom(100,10000,2));
        setValue(getOpeningValue());
        setMin(getOpeningValue());
        setMax(getOpeningValue());

        setnumberOfActions(getRandom(0,2000));
        setActionsLeft(getNumberOfActions());
        setIncome(getRandom(0,100000,2));
        setProfit(getRandom((int)income, 100000,2));
        setIndividualCapital(income*getRandom(5,20));
        setFactoryCapital(individualCapital*getRandom(50,200)/100);

        //volume do ustawienia!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        setTurnover(income*12*getRandom(0,200)/100);
        addToValueList(getValue());

    }


    @Override
    protected synchronized void work(){
        actualizeValue();
        if(getMax()<getValue())max=value;
        if(getMin()>getValue())min=value;
        income = getRandom(0,100000,2);
        profit = getRandom((int)income, 100000,2);
        if(getRandom(0,10)==0)
        {
            int number = getRandom(0,1000);
            numberOfActions+=number;
            actionsLeft += number;
        }
        valueList.add(value);

    }

    @Override
    protected synchronized void actualizeValue(){
        double pow = Math.pow(-1, (double)AdditionalFunctions.getRandom(1,2)); double multi = AdditionalFunctions.getRandom(100,1000,2);
        if(AdditionalFunctions.getRandom(0,10)==0)multi*=AdditionalFunctions.getRandom(1,10);
        if(getValue()-multi<=0)pow=1;
        setValue(getValue()+(multi*pow));
    }

    public synchronized int getNumberOfActions() {
        return numberOfActions;
    }

    public synchronized double getOpeningValue() {
        return openingValue;
    }

    public synchronized void setActionsLeft(int actionsLeft) {
        this.actionsLeft = actionsLeft;
    }

    public synchronized void setOpeningValue(double openingValue) {
        this.openingValue = openingValue;
    }

    public synchronized double getMax() {
        return max;
    }

    public synchronized void setMax(double max) {
        this.max = max;
    }

    @Override
    public synchronized boolean checkIfIsEnough (double budget){

        if(actionsLeft<(int)(budget/value))
            return false;
        return true;
    }

    public synchronized int getActionsLeft() {
        return actionsLeft;
    }

    public synchronized double getTurnover() {
        return turnover;
    }

    public synchronized void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized Date getDate() {
        return date;
    }

    public synchronized void setDate(Date date) {
        this.date = date;
    }

    public synchronized double getMin() {
        return min;
    }

    public synchronized void setMin(double min) {
        this.min = min;
    }

    public synchronized int getnumberOfActions() {
        return numberOfActions;
    }

    public synchronized void setnumberOfActions(int numberOfActions) {
        this.numberOfActions = numberOfActions;
    }

    public synchronized double getProfit() {
        return profit;
    }

    public synchronized void setProfit(double profit) {
        this.profit = profit;
    }

    public synchronized double getIncome() {
        return income;
    }

    public synchronized void setIncome(double income) {
        this.income = income;
    }

    public synchronized double getIndividualCapital() {
        return individualCapital;
    }

    public synchronized void setIndividualCapital(double individualCapital) {
        this.individualCapital = individualCapital;
    }

    public synchronized double getFactoryCapital() {
        return factoryCapital;
    }

    public synchronized void setFactoryCapital(double factoryCapital) {
        this.factoryCapital = factoryCapital;
    }
}
