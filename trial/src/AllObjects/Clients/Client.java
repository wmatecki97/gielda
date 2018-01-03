package AllObjects.Clients;

import functionalClasses.AdditionalFunctions;
import functionalClasses.DataGenerator.DataGenerator;
import functionalClasses.MenuFunctionality;

public class Client {
    protected String firstName;
    protected String surname;
    protected int id;
    protected double budget;



    Client(){
        setFirstName(DataGenerator.getFirstName());
        setSurname(DataGenerator.getSurname());
        id = AdditionalFunctions.getUniqueIndex();
    }

    protected void buy(){

        if(budget>=1)
            MenuFunctionality.getrandomMarket().buy(this ,AdditionalFunctions.getRandom(1,(int)budget,2) );
    }

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
