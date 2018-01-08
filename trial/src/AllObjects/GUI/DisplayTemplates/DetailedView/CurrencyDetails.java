package AllObjects.GUI.DisplayTemplates.DetailedView;

import AllObjects.Goods.Currency;
import AllObjects.Goods.Currency;
import AllObjects.functionalClasses.ChartLine;
import AllObjects.functionalClasses.MenuFunctionality;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CurrencyDetails implements Initializable {

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
    private ListView<String> listView;

    private Currency currency;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        currency = (Currency) MenuFunctionality.getDisplayedObject();
        MenuFunctionality.releaseDisplayedObjectSemaphore();

        if(MenuFunctionality.checkOccuranceInChart(currency.getId()))
            addToChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        else
            deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(false));

        l1.setText("Nazwa: "+currency.getName());
        l2.setText("Wartość: " + currency.getValue());


        ObservableList data = FXCollections.observableArrayList();
        List<String> list = currency.getCountries();
        for(String text: list ){
            data.add(text);
        }
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(data));

    }


    public void deleteItem(ActionEvent actionEvent) {
        MenuFunctionality.deleteObject(currency.getId());
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();
    }

    public void addToChart(ActionEvent actionEvent) {
        MenuFunctionality.addChartLine(currency);
        addToChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(true));
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();
    }

    public void deleteFromChart(ActionEvent actionEvent) {
        MenuFunctionality.deleteChartLine(currency.getId());
        deleteFromChart.visibleProperty().bind(new SimpleBooleanProperty(false));
        addToChart.visibleProperty().bind(new SimpleBooleanProperty(true));
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();
    }

    public void showChart(ActionEvent actionEvent) {
        MenuFunctionality.displayOneObjechChart(currency.getId());
    }
}
