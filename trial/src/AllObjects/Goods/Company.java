package AllObjects.Goods;


import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import static AllObjects.functionalClasses.AdditionalFunctions.getRandom;
import static AllObjects.functionalClasses.AdditionalFunctions.split;
import static java.lang.Thread.sleep;
import java.util.List;

public class Company extends Goods implements Runnable, Serializable{

    private Date date;
    private double min;
    private double max;
    private int numberOfActions;
    private int actionsLeft;
    private double openingValue;
    private double profit;
    private double income;
    private double individualCapital;
    private double factoryCapital;
    private int volume;
    private double turnover;
    private double lastActionsLeftValue;
    private List<Double> valueList;

    protected boolean running;

    public void terminate(){running=false;}

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
        setValueList(new ArrayList<Double>());
        addToValueList(getValue());
        setLastActionsLeftValue(getValue());
        running=true;
    }

    @Override
    public void run() {

        while(running)
        {
            try{
                sleep(5000);
            }
            catch (Exception e){}
            work();
        }

    }

    private synchronized void work(){
        double temp = getValue();
        double pow = Math.pow(-1, (double)AdditionalFunctions.getRandom(1,2)); double multi = AdditionalFunctions.getRandom(100,1000,2);
        if(AdditionalFunctions.getRandom(0,10)==0)multi*=AdditionalFunctions.getRandom(1,10);
        if(getValue()-multi<=0)pow=1;
        setValue(getValue()+(multi*pow));
        if(getMax()<getValue())max=value;
        if(getMin()>getValue())min=value;
        //MOZLIWE ZE KOLEJNE DWA WERSY SA DO WYWALENIA
        setLastActionsLeftValue(temp);
        lastActionsLeftValue = temp;
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

    public synchronized double getLastActionsLeftValue() {
        return lastActionsLeftValue;
    }

    public synchronized void setLastActionsLeftValue(double lastActionsLeftValue) {
        this.lastActionsLeftValue = lastActionsLeftValue;
    }

    public synchronized void setValueList(List<Double> valueList) {
        this.valueList = valueList;
    }

    public synchronized List<Double> getValueList() {
        return valueList;
    }



    private synchronized void addToValueList(Double value){
        valueList.add(value);
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

    public synchronized void display() {
        System.out.println("nazwa: " + name + " data: " + AdditionalFunctions.dateToString(date) + " kurs wymiany: " + super.value + " minimalna wartosc: " + min + " liczba akcji: " + numberOfActions + " zysk: " +
                profit + " przychd: " + income + " kapita wasny: " + individualCapital + " kapita zakadowy: " + factoryCapital + " wolumen: " + volume + " obroty: " + turnover);
    }

    public synchronized String getOutputString(){
        String output = name + " "  + AdditionalFunctions.dateToString(date) + " "  + super.value + " "  + min  + " "  + numberOfActions + " "  +profit + " "  +income + " "  +
                individualCapital + " "  +factoryCapital + " "  +volume + " "  +turnover;
        return output;
    };

    public synchronized Company setValues(String inputString){

        String[] strArr = split(inputString);
        Company output= new Company();

        output.name = strArr[0];   
        //output.date = ; Double.
        output.value = Double.parseDouble(strArr[2]);
        output.min = Double.parseDouble(strArr[3]);
        output.numberOfActions = Integer.parseInt(strArr[4]);
        output.profit = Double.parseDouble(strArr[5]);
        output.income = Double.parseDouble(strArr[6]);
        output.individualCapital = Double.parseDouble(strArr[7]);
        output.factoryCapital = Double.parseDouble(strArr[8]);
        output.volume = Integer.parseInt(strArr[9]);
        output.turnover = Double.parseDouble(strArr[10]);
        return output;

    };

    public synchronized int getVolume() {
        return volume;
    }

    public synchronized void setVolume(int volume) {
        this.volume = volume;
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
