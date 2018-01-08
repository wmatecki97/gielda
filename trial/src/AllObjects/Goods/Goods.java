package AllObjects.Goods;

import AllObjects.functionalClasses.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Goods implements AllInstancess, HasName, Serializable, Runnable, HasValue, ChartItem {

    /**
     * current value of an object
     */
    protected double value;

    protected  String name;
    private int id;
    /**
     * variable to terminate thread
     */
    protected boolean running;
    /**
     * tells if object is rather bought or sold
     */
    private double bought;
    /**
     * list of object values
     */
    protected List<Double> valueList;

    public Goods(){
        value = AdditionalFunctions.getRandom(1,2000,2);
        id = AdditionalFunctions.getUniqueIndex();
        running=true;
        bought=0;
        valueList = new ArrayList<Double>();
    }

    /**
     * actualize object value
     */
    protected synchronized void actualizeValue(){
        double pow;
        if(bought>0)
            pow=1;
        else
            pow=-1;
        double multi = AdditionalFunctions.getRandom(1,200,2);
        if(AdditionalFunctions.getRandom(0,10)==0)multi*=AdditionalFunctions.getRandom(1,10);
        if(getValue()-multi<=0)pow=1;
        setValue(getValue()+(multi*pow));
        addToValueList(value);
        bought=0;
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

    /**
     * terminate object thread
     */
    public synchronized void terminate(){running=false;}

    protected synchronized void work(){
        actualizeValue();
    }

    /**
     * returns list of object values during program work
     * @return
     */
    public synchronized List<Double> getValueList() {
        return valueList;
    }

    /**
     * adds value to the list of item values
     * @param value
     */
    protected synchronized void addToValueList(Double value){
        valueList.add(value);
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void setId(int id) {
        this.id = id;
    }

    public synchronized String getName() {
        return name;
    }

    /**
     * check if is enough actions to buy for cost given
     * @param cost
     * @return
     */
    public synchronized boolean checkIfIsEnough(double cost){

        return true;

    }

    public synchronized void setValue(double value) {
        this.value = value;
    }

    public synchronized double getValue() {
        return value;
    }

    /**
     * add number of bought objects
     * @param amount
     */
    public void bought(double amount) {
        bought+=amount;
    }
}
