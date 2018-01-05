package AllObjects.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DisplayPageController {


    public void displayInvestor(ActionEvent actionEvent) {

        PageOpener.investorPage();

    }

    public void displayInvestmentFund(ActionEvent actionEvent) {

        PageOpener.investmentFundPage();

    }

    public void displayCompany(ActionEvent actionEvent) {
        PageOpener.companyPage();
    }

    public void displayCurrency(ActionEvent actionEvent) {
        PageOpener.currencyPage();
    }

    public void displayExchange(ActionEvent actionEvent) {
        PageOpener.exchangePage();
    }

    public void back(ActionEvent actionEvent) {

        PageOpener.startPage();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    }

    public void displayRawMaterial(ActionEvent actionEvent) {
        PageOpener.rawMaterialPage();
    }
}
