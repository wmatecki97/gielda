package AllObjects;

import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.DataGenerator.DataGenerator;

import static java.lang.Thread.sleep;

public class InvestmentFund extends Client implements AllInstancess, Runnable{

    private String name;
    private Double Value;

    public InvestmentFund(){
        name = DataGenerator.getName();
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
        }

    }

    public synchronized void display(){
        super.display();
        System.out.print("nazwa: " + name +"\n");
    }

    public synchronized String getOutputString(){

        String output="";
        output=name +" "+ super.getOutputString();
        return output;
    };

    public synchronized InvestmentFund setValues(String inputString){

        String[] strArr = AdditionalFunctions.split(inputString);
        InvestmentFund output = new InvestmentFund();

        output.name = strArr[0];
        output.setFirstName(strArr[1]);
        output.setSurname(strArr[2]);

        return output;

    };

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }


}
