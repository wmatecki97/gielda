package AllObjects.GUI;

import functionalClasses.MenuFunctionality;
import javafx.event.ActionEvent;

public class AddPageController {


    public void addInvestor(ActionEvent actionEvent) {

        MenuFunctionality.addNewInvestor();
        
    }

    public void addInvestmentFund(ActionEvent actionEvent) {

        MenuFunctionality.addNewInvestmentFund();

    }

    public void addCompany(ActionEvent actionEvent) {

        MenuFunctionality.addNewCompany();

    }


    public void addCurrency(ActionEvent actionEvent) {

        MenuFunctionality.addNewCurrency();

    }

    public void addExchange(ActionEvent actionEvent) {

        MenuFunctionality.addNewExchange();

    }
}
