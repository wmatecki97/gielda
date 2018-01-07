package AllObjects.GUI.DisplayTemplates.DetailedView;

import AllObjects.Clients.InvestmentFund;
import AllObjects.Goods.Company;
import AllObjects.functionalClasses.AdditionalFunctions;
import AllObjects.functionalClasses.MenuFunctionality;
import AllObjects.functionalClasses.Purchase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CompanyDetails implements Initializable{
    @FXML
    private AnchorPane pane;

    @FXML
    private Button deleteItem;
    @FXML
    private Button addToChart;
    @FXML
    private Button deleteFromChart;

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    @FXML
    private Label l9;
    @FXML
    private Label l10;
    @FXML
    private Label l11;
    @FXML
    private Label l12;
    @FXML
    private Label l13;


    private Company company;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        company = (Company) MenuFunctionality.getDisplayedObject();
        MenuFunctionality.releaseDisplayedObjectSemaphore();

        if(MenuFunctionality.checkOccuranceInChart(company.getId()))
            addToChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        else
            deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(false));

        l1.setText("Nazwa: "+company.getName());
        l2.setText("Data pierwszej wyceny: " + AdditionalFunctions.dateToString(company.getDate()));
        l3.setText("Minimum: " + AdditionalFunctions.doubleToShortString(company.getMin()));
        l4.setText("Maximum: "+ AdditionalFunctions.doubleToShortString(company.getMax()));
        l11.setText("Liczba akcji: "+ company.getnumberOfActions());
        l6.setText("Cena otwarcia: " +AdditionalFunctions.doubleToShortString(company.getOpeningValue()));
        l7.setText("Przychód: " + company.getIncome());
        l8.setText("Zysk: " + company.getProfit());
        l5.setText("Aktualna wartość akcji: " + AdditionalFunctions.doubleToShortString(company.getValue()));
        l10.setText("Kapitał własny: " + company.getIndividualCapital());
        l9.setText("Kapitał zakładowy: " + company.getFactoryCapital());
        l12.setText("Obroty: " + company.getTurnover());
       // l13.setText(": " + company.);



    }

    public void deleteItem(ActionEvent actionEvent) {

        MenuFunctionality.deleteObject(company.getId());
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();

    }

    public void addToChart(ActionEvent actionEvent) {

        MenuFunctionality.addChartLine(company);
        addToChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(true));
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();
    }

    public void deleteFromChart(ActionEvent actionEvent) {

        MenuFunctionality.deleteChartLine(company.getId());
        deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        addToChart.visibleProperty().bind(new SimpleBooleanProperty(true));
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();

    }
}
