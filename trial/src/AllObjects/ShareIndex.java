package AllObjects;

import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;

public class ShareIndex implements AllInstancess {
    private int index;
    private double value;

    public String getOutputString(){
        String output = index + " " + value;
        return output;
    };

    public ShareIndex setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        ShareIndex output = new ShareIndex();

        output.index = Integer.parseInt(strArr[0]);
        output.value = Double.parseDouble(strArr[1]);

        return output;
    };

    public void display(){
        System.out.println("index: " + index + " wartosc: " + value);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
