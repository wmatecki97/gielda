package AllObjects;

import functionalClasses.AdditionalFunctions;
import functionalClasses.DataGenerator.DataGenerator;

public class Client {
    protected String firstName;
    protected String surname;
    protected int id;
    protected double budget;

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }




    Client(){
        setFirstName(DataGenerator.getFirstName());
        setSurname(DataGenerator.getSurname());
        id = AdditionalFunctions.getUniqueIndex();
    }

    protected void buy(){


        if(budget>=1)
            AdditionalFunctions.getRandomExchange().buy(AdditionalFunctions.getRandom(1,(int)budget,2), this);

    }

    public void display(){
      System.out.print("imie: " + firstName + " nazwisko: " + surname + " ");
    }

    public String getOutputString() {
        return(firstName + " " + surname);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {  return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
