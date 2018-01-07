package AllObjects.Goods;

import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.HasName;

import java.io.Serializable;

public class Goods implements AllInstancess, HasName, Serializable {

    protected double value;
    protected  String name;
    private int id;

    public synchronized int getId() {
        return id;
    }

    public synchronized void setId(int id) {
        this.id = id;
    }

    public synchronized String getName() {
        return name;
    }

    public Goods(){
        value = AdditionalFunctions.getRandom(1,2000,2);
        id = AdditionalFunctions.getUniqueIndex();
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
