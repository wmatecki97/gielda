package AllObjects.Goods;

import AllObjects.GUI.PageOpener;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;
import AllObjects.functionalClasses.MenuFunctionality;

import java.io.Serializable;
import java.util.List;

public class Currency extends Goods implements Serializable {

    /**
     * list of countries which uses this currency
     */
    private List<String> countries;



    public Currency(){
        try{

            name = DataGenerator.getCurrency();
            int numberOfCountries = AdditionalFunctions.getRandom(1,5);
            countries = DataGenerator.getCountries(numberOfCountries);
        }
        catch(Exception e){
            MenuFunctionality.setErrorMessage("Nie można dodać więcej obiektów tego typu");
            PageOpener.popUp();
        }
    }

    public synchronized List<String> getCountries() {
        return countries;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }


}
