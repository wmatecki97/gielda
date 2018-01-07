package AllObjects.Goods;

import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.HasName;

import java.io.Serializable;

import static java.lang.Thread.sleep;

public class Goods implements AllInstancess, HasName, Serializable, Runnable {

    protected double value;
    protected  String name;
    private int id;
    protected boolean running;

    public Goods(){
        value = AdditionalFunctions.getRandom(1,2000,2);
        id = AdditionalFunctions.getUniqueIndex();
        running=true;
    }

    protected synchronized void actualizeValue(){
        double pow = Math.pow(-1, (double)AdditionalFunctions.getRandom(1,2)); double multi = AdditionalFunctions.getRandom(1,200,2);
        if(AdditionalFunctions.getRandom(0,10)==0)multi*=AdditionalFunctions.getRandom(1,10);
        if(getValue()-multi<=0)pow=1;
        setValue(getValue()+(multi*pow));
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

    public synchronized void terminate(){running=false;}

    protected synchronized void work(){
        actualizeValue();
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



    public synchronized boolean checkIfIsEnough(double cost){

        return true;

    }

    public synchronized void setValue(double value) {
        this.value = value;
    }

    public synchronized double getValue() {
        return value;
    }

    @Override
    public synchronized String getOutputString() {
        return null;
    }

    @Override
    public synchronized AllInstancess setValues(String a) {
        return null;
    }

    @Override
    public synchronized void display() {

    }
}
