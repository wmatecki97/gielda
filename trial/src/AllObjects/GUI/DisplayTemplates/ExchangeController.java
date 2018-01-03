package AllObjects.GUI.DisplayTemplates;

import AllObjects.Exchange;
import AllObjects.Investor;
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

public class ExchangeController implements Initializable {

    @FXML
    private TableView<Exchange> tableView;


    public void initialize(URL location, ResourceBundle resources) {

        TableColumn nameColumn = new TableColumn("Nazwa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn countryColumn = new TableColumn("Kraj");
        countryColumn.setCellValueFactory(new PropertyValueFactory("country"));
        TableColumn currencyColumn = new TableColumn("Waluta");
        currencyColumn.setCellValueFactory(new PropertyValueFactory("currency"));
        TableColumn cityColumn = new TableColumn("Miasto");
        cityColumn.setCellValueFactory(new PropertyValueFactory("city"));
        TableColumn adressColumn = new TableColumn("Adres siedziby");
        adressColumn.setCellValueFactory(new PropertyValueFactory("adress"));
        TableColumn markupColumn = new TableColumn("Marża");
        markupColumn.setCellValueFactory(new PropertyValueFactory("markup"));
        TableColumn goodsColumn = new TableColumn("Lista dóbr możliwyych do kupienia");
        goodsColumn.setCellValueFactory(new PropertyValueFactory("goods"));


        tableView.getColumns().addAll(nameColumn, countryColumn, currencyColumn, cityColumn, adressColumn, markupColumn, goodsColumn);
        ObservableList<Exchange> data = tableView.getItems();
        List<AllInstancess> list = MenuFunctionality.getExchangeList();
        for (int i = -0; i < list.size(); i++) {
            data.add((Exchange) list.get(i));
        }


    }
}
