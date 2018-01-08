package AllObjects.functionalClasses;

import AllObjects.Clients.Client;
import AllObjects.Market.Exchange;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;

public class AdditionalFunctions {

    private static List<Integer> indexList= new ArrayList<Integer>();

    /**
     * Converts list of String to string
     * @param inputList
     * @return String
     */
    public static String ListToString(List<String> inputList){
        String output="";
        for (String item : inputList) {
            output+=item+", ";
        }
        output=output.substring(0,output.length()-2);
        return output;
    }

    /**
     * Returns unique index
     * @return
     */
    public static int getUniqueIndex(){
        int i=0;
        while(indexList.indexOf(i)!=-1) i++;
        indexList.add(i);
        return i;
    }

    /**
     * converts date to dd-mm-yyyy String
     * @param myDate
     * @String dd-mm-yyyy
     */
    public static String dateToString(Date myDate){

        String result="";
        if(myDate.getDate()<10)
            result ="0"+myDate.getDate();
        else
            result = result + myDate.getDate();
        result+="-";
        if(myDate.getMonth()<10)
            result += "0" + myDate.getMonth();
        else
            result += myDate.getMonth();
        result+="-";
        result += (myDate.getYear()+1900);
        return  result;
    }

    private static Random rand = new Random();

    public static int getRandom(int min, int max){

        return rand.nextInt(max-min+1)+min;

    }

    /**
     * Max value must be greater or equal than min value
     * @param min
     * @param max
     * @param precission
     * @return double
     */
    public static double getRandom(int min, int max, int precission){

        if(precission>9)precission=9;
        int exponent = (int)pow(10.0, (double)precission+1);
        return getRandom(min, max)+getRandom(0,exponent)/exponent;

    }


    public static AllInstancess getRandomGood(){

        return MenuFunctionality.getRandomGoods();

    }


    public static String doubleToShortString(double d){
        int length=0;
        for(int i=1; i<d*1000; i*=10){
            length++;
        }
        String result = String.valueOf(d);
        if(result.length()<length)
            length=result.length();
        return String.valueOf(d).substring(0,length);

    }

}
