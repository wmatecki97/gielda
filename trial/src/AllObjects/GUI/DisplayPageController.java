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
        /*
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("StartPageView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Inwestorzy");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
*/

        PageOpener.startPage();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    }
}
