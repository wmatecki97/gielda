package AllObjects;

import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.AllInstancess;

public class ShareIndex implements AllInstancess {
    private int index;
    private double value;

    public synchronized String getOutputString(){
        String output = index + " " + value;
        return output;
    };

    public synchronized ShareIndex setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        ShareIndex output = new ShareIndex();

        output.index = Integer.parseInt(strArr[0]);
        output.value = Double.parseDouble(strArr[1]);

        return output;
    };

    public synchronized void display(){
        System.out.println("index: " + index + " wartosc: " + value);
    }

    public synchronized int getIndex() {
        return index;
    }

    public synchronized void setIndex(int index) {
        this.index = index;
    }

    public synchronized double getValue() {
        return value;
    }

    public synchronized void setValue(double value) {
        this.value = value;
    }
}
