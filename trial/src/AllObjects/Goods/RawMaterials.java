package AllObjects.Goods;

import AllObjects.GUI.PageOpener;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;
import AllObjects.functionalClasses.MenuFunctionality;

import java.io.Serializable;

public class RawMaterials extends Goods implements Serializable{

    private String unit;
    private int currencyId;
    /**
     * currency name
     */
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
            MenuFunctionality.setErrorMessage("Nie można dodać więcej obiektów tego typu");
            PageOpener.popUp();
        }
    }

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

    public synchronized double getMax() {
        return max;
    }
}
