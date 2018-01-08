package AllObjects.GUI.DisplayTemplates.DetailedView;

import AllObjects.Clients.InvestmentFund;
import AllObjects.Goods.RawMaterials;
import AllObjects.functionalClasses.MenuFunctionality;
import AllObjects.functionalClasses.Purchase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RawMaterialsDetails implements Initializable {


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
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;


    private RawMaterials material;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        material = (RawMaterials) MenuFunctionality.getDisplayedObject();
        MenuFunctionality.releaseDisplayedObjectSemaphore();

        if(MenuFunctionality.checkOccuranceInChart(material.getId()))
            addToChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        else
            deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(false));

        l1.setText("Nazwa: "+material.getName());
        l2.setText("Jednostka: " + material.getUnit());
        l3.setText("Waluta: " + material.getCurrency());
        l5.setText("ID: "+material.getId());
        l6.setText("Wartość jednostki: "+ material.getValue());
        l7.setText("Wartość minimalna: "+ material.getMin());
        l8.setText("Wartość maksymalna: "+ material.getMax());

    }
    
    
    public void deleteItem(ActionEvent actionEvent) {
        MenuFunctionality.deleteObject(material.getId());
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();
    }

    public void addToChart(ActionEvent actionEvent) {
        MenuFunctionality.addChartLine(material);
        addToChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(true));
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();
    }

    public void deleteFromChart(ActionEvent actionEvent) {
        MenuFunctionality.deleteChartLine(material.getId());
        deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        addToChart.visibleProperty().bind(new SimpleBooleanProperty(true));
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();
    }


    public void showChart(ActionEvent actionEvent) {
        MenuFunctionality.displayOneObjechChart(material.getId());
    }
}
