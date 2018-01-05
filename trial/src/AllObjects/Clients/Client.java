package AllObjects.Clients;

import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.DataGenerator.DataGenerator;
import AllObjects.functionalClasses.Purchase;

import java.util.List;

public class Client {
    protected String firstName;
    protected String surname;
    protected int id;
    protected double budget;
    protected List<Purchase> purchaseList;

    Client(){
        setFirstName(DataGenerator.getFirstName());
        setSurname(DataGenerator.getSurname());
        id = AdditionalFunctions.getUniqueIndex();
    }

    public void goodHasBeenDeleted(int id){
        for(int i=0; i<purchaseList.size(); i++){
            if(purchaseList.get(i).getSubjectId()==id){
                purchaseList.remove(i);
                i--;
            }
        }
    }

    protected void buy(){}

    public synchronized void display(){
      System.out.print("imie: " + firstName + " nazwisko: " + surname + " ");
    }

    public synchronized String getOutputString() {
        return(firstName + " " + surname);
    }

    public int getId() {
        return id;
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
}
