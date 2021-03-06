package AllObjects.GUI.DisplayTemplates;

import AllObjects.Market.Exchange;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.MenuFunctionality;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExchangeController implements Initializable {

    @FXML
    private TableView<Exchange> tableView;

	@FXML
	private AnchorPane pane;


    public void initialize(URL location, ResourceBundle resources) {

        tableView.prefWidthProperty().bind(pane.widthProperty());
        tableView.prefHeightProperty().bind(pane.heightProperty());

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
        TableColumn goodsColumn = new TableColumn("Lista spółek z ideksu");
        goodsColumn.setCellValueFactory(new PropertyValueFactory("goods"));


        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        countryColumn.prefWidthProperty().bind(tableView.widthProperty().divide(10));
        currencyColumn.prefWidthProperty().bind(tableView.widthProperty().divide(10));
        cityColumn.prefWidthProperty().bind(tableView.widthProperty().divide(10));
        adressColumn.prefWidthProperty().bind(tableView.widthProperty().divide(10));
        markupColumn.prefWidthProperty().bind(tableView.widthProperty().divide(20));
        goodsColumn.prefWidthProperty().bind(tableView.widthProperty().divide(2.5));
    //    goodsColumn.prefWidthProperty().bind(pane.widthProperty().subtract(nameColumn.getWidth()+countryColumn.getWidth()+currencyColumn.getWidth()+cityColumn.getWidth()+adressColumn.getWidth()+markupColumn.getWidth()));

        tableView.getColumns().addAll(nameColumn, countryColumn, currencyColumn, cityColumn, adressColumn, markupColumn, goodsColumn);
        ObservableList<Exchange> data = tableView.getItems();
        List<AllInstancess> list = MenuFunctionality.getExchangeList();

        for(AllInstancess exc: list){
            data.add((Exchange) exc);
        }


    }
}
