package AllObjects.Market;


import AllObjects.Goods.Company;
import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.MenuFunctionality;
import AllObjects.functionalClasses.Purchase;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ShareIndex implements AllInstancess, Runnable {

    private String name;
    private int id;
    private double value;
    private List<Company> companyList;
    private boolean running;

    @Override
    public void run() {

        while(running)
        {
            try{
                sleep(5000);
            }
            catch (Exception e){}
            work();
        }

    }

    public ShareIndex(String name) {
        this.name = name;
        companyList = new ArrayList<>();
        id = AdditionalFunctions.getUniqueIndex();
    }

    public synchronized void terminate(){running=false;}

    private synchronized void work(){

        double temp =0;
        for(Company company: companyList){
            temp+=MenuFunctionality.getGoodValue(company.getId());
        }
        value = temp;
    }

    public synchronized void addToList(Company company){
        companyList.add(company);
    }

    public synchronized void deleteFromList(Company company){
        for(int i=0; i<companyList.size(); i++){
            if(companyList.get(i).getId()==company.getId()){
                companyList.remove(i);
                return;
            }
        }
    }

    public synchronized double getValue() {
        return value;
    }

    public synchronized void setValue(double value) {
        this.value = value;
    }



}
