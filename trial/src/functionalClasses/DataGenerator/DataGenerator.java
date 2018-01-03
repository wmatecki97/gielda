package functionalClasses.DataGenerator;

import functionalClasses.AdditionalFunctions;

import java.util.*;

public class DataGenerator {

    private static List<String> firstNameList = new ArrayList<String>();
    private static List<String> nameList = new ArrayList<String>();
    private static List<String> surnameList = new ArrayList<String>();
    private static List<String> countryList = new ArrayList<String>();
    private static List<String> currencyList = new ArrayList<String>();
    private static List<String> rawMaterialNameList = new ArrayList<String>();
    private static List<String> rawMaterialUnitList = new ArrayList<String>();
    private static List<String> cityList = new ArrayList<>();
    private static List<String> streetList = new ArrayList<>();
    private static List<String> exchangeList = new ArrayList<>();


    private static String getUniqueFromList(List<String> mylist){

        int index;
        while(true)
        {
            index = AdditionalFunctions.getRandom(0, mylist.size()-1);
            if(mylist.get(index)!="")break;
        }

        String result = mylist.get(index);
        mylist.set(index,"");
        return result;
    }

    private static String getRandomFromList (List<String> inputList){

        return inputList.get(AdditionalFunctions.getRandom(0, inputList.size()-1));

    }

    private static void checkIsDataValid() {
        if(firstNameList.isEmpty())
            AssignData.assignData(firstNameList, nameList, surnameList, countryList, currencyList, rawMaterialNameList, rawMaterialUnitList, cityList, streetList, exchangeList);
    }

    public static String getFirstName(){
        checkIsDataValid();
        return getRandomFromList(firstNameList);
    }

    public static String getSurname(){
        checkIsDataValid();
        return getRandomFromList(surnameList);
    }

    public static String getName(){
        checkIsDataValid();
        return getUniqueFromList(nameList);
    }

    public static String getCountry(){
        checkIsDataValid();
        return  getRandomFromList(countryList);
    }

    public static String getCity(){
        checkIsDataValid();
        return  getRandomFromList(cityList);
    }

    public static String getStreet(){
        checkIsDataValid();
        return  getRandomFromList(streetList);
    }

    public static List<String> getCountries(int numberOfElements){
        checkIsDataValid();
        List<String> result = new ArrayList<>();
        while(numberOfElements>0)
        {
            result.add(getUniqueFromList(countryList));
            numberOfElements--;
        }
        countryList = new ArrayList<>();
        AssignData.assignCountries(countryList);
        return result;
    }

    public static String getPESEL(){
        String result = "";
        result+=AdditionalFunctions.getRandom(30,90);
        result+=AdditionalFunctions.getRandom(10,12);
        result+=AdditionalFunctions.getRandom(10,30);
        result+=AdditionalFunctions.getRandom(10000,99999);
        return result;
    }

    public static String getCurrency(){
        checkIsDataValid();
        return  getUniqueFromList(currencyList);
    }

    public static Date getDate(){
        int day, month, year;
        Date test=null;
        boolean isGood=false;
        while(!isGood)
        {
            try{
                day =AdditionalFunctions.getRandom(1,31);
                month= AdditionalFunctions.getRandom(1,12);
                year = AdditionalFunctions.getRandom(1950,2016);
                test = new GregorianCalendar(year, month, day).getTime();
                isGood=true;
            }
            catch (Exception e){
                isGood=false;
            }
        }
        return test;
    }

    public static String[] getRawMaterial(){

        boolean isGood=false;
        for(int i=0; i<rawMaterialUnitList.size(); i++)//checking if is any raw material not used yet
        {
            if(!rawMaterialUnitList.get(i).equals(""))
            {
                isGood=true;
                break;
            }
        }
        if(!isGood)return null;

        isGood=false;
        String[] result = new String[2];

        int index;
        while(!isGood){
            index = AdditionalFunctions.getRandom(0, rawMaterialNameList.size()-1);
            if(!rawMaterialNameList.get(index).equals("")){
                isGood=true;
                result[0]=rawMaterialNameList.get(index);
                result[1]=rawMaterialUnitList.get(index);
                rawMaterialUnitList.set(index,"");
                rawMaterialNameList.set(index,"");
            }
        }
        return result;
    }

    public static String getExchangeName(){

        checkIsDataValid();
        return getUniqueFromList(exchangeList);

    }


}
