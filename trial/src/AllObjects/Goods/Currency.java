package AllObjects.Goods;

import AllObjects.GUI.PageOpener;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;

import java.util.List;

public class Currency extends Goods {

    private List<String> countries;



    public Currency(){
        try{

            name = DataGenerator.getCurrency();
            int numberOfCountries = AdditionalFunctions.getRandom(1,5);
            countries = DataGenerator.getCountries(numberOfCountries);
            countriesList = AdditionalFunctions.ListToString(countries);
        }
        catch(Exception e){
            PageOpener.emptyGenerator();
        }
    }

    public synchronized void display(){
        System.out.print("nazwa: " + name + " cena: " + super.value + " lista krajow: ");
        String b ="";
        for (String a : countries) {
            b+=a+" | ";
        }
        b=b.substring(0,b.length()-3);
        System.out.println(b);
    }

    public synchronized String getOutputString(){
        String output = name + " " + value + " " + AdditionalFunctions.ListToString(countries);
        return output;
    };

    public synchronized Currency setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        Currency output = new Currency();

        output.name = strArr[0];
        output.value = Double.parseDouble(strArr[1]);

        for(int i=2; i<strArr.length; i++)
        {
            output.countries.add(strArr[i]);
        }

        return output;
    };

    public synchronized void addToList(String a)
    {
        countries.add(a);
    }

    public synchronized List<String> getCountries() {
        return countries;
    }

    public synchronized void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized String getCountriesList() {
        return countriesList;
    }

    private String countriesList;
}
