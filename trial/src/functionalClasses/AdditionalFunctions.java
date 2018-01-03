package functionalClasses;

import AllObjects.Client;
import AllObjects.Exchange;
import AllObjects.Goods.Goods;
import functionalClasses.AllInstancess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;

public class AdditionalFunctions {

    private static List<Integer> indexList= new ArrayList<Integer>();

    public static String ListToString(List<String> inputList){
        String output="";
        for (String item : inputList) {
            output+=item+" ";
        }
        output=output.substring(0,output.length()-1);
        return output;
    }

    public static String[] split(String inputString){ //split read line of text to array of strings

        int counter=1;
        List<Integer> separateIndex = new ArrayList<>();
        separateIndex.add(-1);

        char[] inputArr = inputString.toCharArray();

        for( int i=0; i<inputString.length(); i++){ //create a list of index where to separate
            if(inputArr[i]==' ') {
                counter++;
                separateIndex.add(i);
            }
        }
        separateIndex.add(inputString.length());
        String[] outputArr = new String[counter];

        for(int i=0; i<counter; i++){

            outputArr[i] = inputString.substring(separateIndex.get(i)+1, separateIndex.get(i+1));
        }

        return outputArr;

    }

    public static void display(List<AllInstancess> inputList){
        int i=0;
        for (AllInstancess temp : inputList){
            System.out.print(i+") ");
            i++;
            temp.display();
        }

    }

    public static int getUniqueIndex(){
        int i=0;
        while(indexList.indexOf(i)!=-1) i++;
        indexList.add(i);
        return i;
    }

    public static void checkIndex(List<Client> clientList, int index){

        for(Client temp : clientList){
            if(index==temp.getId()){
                indexList.remove(index);
            }
        }
    }

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

    public static double getRandom(int min, int max, int precission){
        if(precission>9)precission=9;
        int exponent = (int)pow(10.0, (double)precission);
        return getRandom(min*exponent, max*exponent)/exponent;
    }

    public static Exchange getRandomExchange(){

        return MenuFunctionality.getRandomExchange();

    }

    public static AllInstancess getRandomGood(){

        return MenuFunctionality.getRandomGoods();

    }


}
