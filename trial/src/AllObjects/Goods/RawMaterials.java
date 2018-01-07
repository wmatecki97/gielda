package AllObjects.Goods;

import AllObjects.GUI.PageOpener;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;
import AllObjects.functionalClasses.MenuFunctionality;

public class RawMaterials extends Goods{

    private String unit;
    private int currencyId;
    private String currency;

    private double min;
    private double max;

    public RawMaterials(){
        //NAZWA I JEDNOSTKA DO ZDEFINIOWANIA W KLASIE DATAGENERATOR
        currencyId = MenuFunctionality.getCurrencyList().get(AdditionalFunctions.getRandom(0,MenuFunctionality.getCurrencyList().size()-1)).getId();
        currency = MenuFunctionality.getGood(currencyId).getName();
        min = value;
        max = value;
        try{
            String[] materialData = DataGenerator.getRawMaterial();
            setName(materialData[0]);
            setUnit(materialData[1]);
        }
        catch (NullPointerException e)
        {
            PageOpener.emptyGenerator();
        }
    }

    public synchronized void display(){
        System.out.println(" nazwa: " + name + " jednostka: " + unit + " waluta: " + currency + " wartosc: " + value + "minimalna wartosc: " + min + " maksymalna wartosc: " + max);
    }

    public synchronized String getOutputString(){
        String output = name + " " + unit + " " + currency + " " + value + " " + min + " " + max;
        return output;
    };

    public synchronized RawMaterials setValues(String inputString){

        RawMaterials output = new RawMaterials();
        String[] strArr = AdditionalFunctions.split(inputString);

        output.name = strArr[0];
        output.unit = strArr[1];
        //output.currency = strArr[2];
        output.value = Double.parseDouble(strArr[3]);
        output.min = Double.parseDouble(strArr[4]);
        output.max = Double.parseDouble(strArr[5]);

        return output;
    };

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized String getUnit() {
        return unit;
    }

    public synchronized void setUnit(String unit) {
        this.unit = unit;
    }

    public synchronized int getCurrencyId() {
        return currencyId;
    }

    public synchronized String getCurrency() {
        return currency;
    }

    public synchronized double getValue() {
        return value;
    }

    public synchronized void setValue(double value) {
        this.value = value;
    }

    public synchronized double getMin() {
        return min;
    }

    public synchronized void setMin(double min) {
        this.min = min;
    }

    public synchronized double getMax() {
        return max;
    }

    public synchronized void setMax(double max) {
        this.max = max;
    }
}
