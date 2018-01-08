package AllObjects.GUI.DisplayTemplates;

import AllObjects.GUI.PageOpener;
import AllObjects.Goods.Currency;
import AllObjects.Goods.Goods;
import AllObjects.functionalClasses.MenuFunctionality;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable{


    @FXML
    private TableView<Currency> tableView;

	@FXML
	private AnchorPane pane;


    public void initialize(URL location, ResourceBundle resources) {


        tableView.prefWidthProperty().bind(pane.widthProperty());
        tableView.prefHeightProperty().bind(pane.heightProperty());

        TableColumn nameColumn = new TableColumn("Nazwa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn priceColumn= new TableColumn("Cena kupna/sprzedaży");
        priceColumn.setCellValueFactory(new PropertyValueFactory("value"));

        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(2));
        priceColumn.prefWidthProperty().bind(tableView.widthProperty().divide(2));


        tableView.getColumns().addAll(nameColumn, priceColumn);
        ObservableList<Currency> data = tableView.getItems();
        List<Goods> list = MenuFunctionality.getCurrencyList();
        for (Goods currency:list) {
            data.add((Currency) currency);
        }

        tableView.setRowFactory( tv -> {
            TableRow<Currency> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Currency rowData = row.getItem();
                    if(rowData!=null){
                        if(MenuFunctionality.checkItemOccurance(rowData.getId())){
                            MenuFunctionality.setDisplayedObject(rowData);
                            PageOpener.detailsCurrency();
                        }
                    }
                }
            });
            return row ;
        });


    }
}
