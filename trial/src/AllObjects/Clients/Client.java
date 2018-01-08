package AllObjects.Clients;

import AllObjects.Goods.Goods;
import AllObjects.functionalClasses.*;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;

import java.io.Serializable;
import java.util.List;

import static java.lang.Thread.sleep;

public class Client implements Serializable, Runnable {
    protected String firstName;
    protected String surname;
    protected int id;
    protected double budget;
    /**
     * list of purchases
     */
    protected List<Purchase> purchaseList;
    /**
     * variable to terminate thread
     */
    protected boolean running;

    Client(){
        setFirstName(DataGenerator.getFirstName());
        setSurname(DataGenerator.getSurname());
        id = AdditionalFunctions.getUniqueIndex();
        running=true;
    }

    @Override
    public void run() {
        while(running)
        {
            try{
                sleep(5000);
            }
            catch (Exception e){}
            if(AdditionalFunctions.getRandom(0,1)==0 || purchaseList.size()==0)
                buy();
            else
                sell();
            work();
        }
    }

    protected void work() {
    }

    /**
     * allows to terminate objects thread
     */
    public synchronized void terminate(){running=false;}

    /**
     * deletes deleted object from list
     * @param id
     */
    public synchronized void goodHasBeenDeleted(int id){
        for(int i=0; i<purchaseList.size(); i++){
            if(purchaseList.get(i).getSubjectId()==id){
                purchaseList.remove(i);
                return;
            }
        }
    }

    protected void buy(){}

    public synchronized void addToPurchasesList(Purchase purchase){
        for(Purchase purch: purchaseList){
            if(purch.getSubjectId()==purchase.getSubjectId()){
                purch.setAmount(purch.getAmount()+purchase.getAmount());
                return;
            }
        }
        purchaseList.add(purchase);
    }

    public int getId() {
        return id;
    }

    protected synchronized void sell(){
        Purchase purchase = purchaseList.get(AdditionalFunctions.getRandom(0,purchaseList.size()-1));
        HasValue good =(HasValue) MenuFunctionality.getGood(purchase.getSubjectId());
        setBudget(getBudget() + purchase.getAmount() * good.getValue());
        deletePurchase(purchase.getSubjectId());
        String name = good.getClass().getSimpleName();
        MenuFunctionality.sellGood(good, -1*purchase.getAmount());

    }

    public synchronized double getBudget() {
        return budget;
    }

    public synchronized void setBudget(double budget) {
        this.budget = budget;
    }

    public synchronized void setId(int id) {
        this.id = id;
    }

    public synchronized String getFirstName() {  return firstName; }

    public synchronized void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public synchronized String getSurname() {
        return surname;
    }

    public synchronized void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * deletes purchases of given subject id
     * @param subjectId
     */
    public void deletePurchase(int subjectId) {
        for(int i=0; i<purchaseList.size(); i++){
            if(purchaseList.get(i).getSubjectId()==subjectId){
                purchaseList.remove(i);
                return;
            }
        }
    }


}
