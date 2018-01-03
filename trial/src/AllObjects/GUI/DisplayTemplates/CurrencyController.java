package AllObjects.GUI.DisplayTemplates;

import AllObjects.Goods.Currency;
import AllObjects.Investor;
import functionalClasses.AdditionalFunctions;
import functionalClasses.AllInstancess;
import functionalClasses.MenuFunctionality;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable{


    @FXML
    private TableView<Currency> tableView;


    public void initialize(URL location, ResourceBundle resources) {


        TableColumn nameColumn = new TableColumn("Nazwa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn priceColumn= new TableColumn("Cena kupna/sprzedaży");
        priceColumn.setCellValueFactory(new PropertyValueFactory("value"));
        TableColumn countryColumn= new TableColumn("Lista krajów");
        countryColumn.setCellValueFactory(new PropertyValueFactory("countries"));




        tableView.getColumns().addAll(nameColumn, priceColumn, countryColumn);
        ObservableList<Currency> data = tableView.getItems();
        List<AllInstancess> list = MenuFunctionality.getCurrencyList();
        for (int i = -0; i < list.size(); i++) {
            data.add((Currency) list.get(i));
        }


    }
}
