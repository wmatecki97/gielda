package AllObjects;

import AllObjects.Goods.Goods;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.DataGenerator.DataGenerator;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Investor extends Client implements AllInstancess, Runnable{
    private String PESEL;

    public Investor(){
        PESEL = DataGenerator.getPESEL();
        budget = AdditionalFunctions.getRandom(5000,10000000);
        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        while(true)
        {
            try{
                sleep(5000);
            }
            catch (Exception e){}
            buy();
            if(AdditionalFunctions.getRandom(0,10)==1) increaseBudget();
        }

    }



    public synchronized void display(){
        super.display();
        System.out.print("PESEL: " + PESEL + " budżet: " + budget+ "\n");
    }

    public synchronized String getOutputString(){

        String output="";

        output=PESEL+" " + budget +" "+ super.getOutputString();
        return output;
    };

    public synchronized Investor setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        Investor output = new Investor();

        output.PESEL = strArr[0];
        output.budget = Double.parseDouble(strArr[1]);
        output.setFirstName(strArr[2]);
        output.setSurname(strArr[3]);

        return output;
    }

    private void increaseBudget(){
        budget+=AdditionalFunctions.getRandom(1,100);
    }

    public synchronized String getPESEL() {
        return PESEL;
    }

    public synchronized void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public synchronized double getBudget() {
        return budget;
    }

    public synchronized void setBudget(double budget) {
        this.budget = budget;
    }


}
