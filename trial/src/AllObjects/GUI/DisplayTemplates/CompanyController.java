package AllObjects.GUI.DisplayTemplates;

import AllObjects.Clients.Investor;
import AllObjects.GUI.PageOpener;
import AllObjects.Goods.Company;
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

public class CompanyController implements Initializable {

    @FXML
    private TableView<Company> tableView;

	@FXML
	private AnchorPane pane;

    public void initialize(URL location, ResourceBundle resources) {


        tableView.prefWidthProperty().bind(pane.widthProperty());

        TableColumn nameColumn = new TableColumn("Nazwa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn dateColumn = new TableColumn("Data pierwszej wyceny");
        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
        TableColumn minColumn = new TableColumn("Minimalna wartość akcji");
        minColumn.setCellValueFactory(new PropertyValueFactory("min"));
        TableColumn numberOfActionColumn = new TableColumn("Liczba akcji");
        numberOfActionColumn.setCellValueFactory(new PropertyValueFactory("numberOfActions"));
        TableColumn openingColumn = new TableColumn("Kurs otwarcia");
        openingColumn.setCellValueFactory(new PropertyValueFactory("openingValue"));
        TableColumn valueColumn = new TableColumn("Aktualna wartość akcji");
        valueColumn.setCellValueFactory(new PropertyValueFactory("value"));
        TableColumn profitColumn = new TableColumn("Zysk");
        profitColumn.setCellValueFactory(new PropertyValueFactory("profit"));
        TableColumn incomeColumn = new TableColumn("Przychód");
        incomeColumn.setCellValueFactory(new PropertyValueFactory("income"));
        TableColumn ownCapitalColumn = new TableColumn("Kapitał własny");
        ownCapitalColumn.setCellValueFactory(new PropertyValueFactory("individualCapital"));
        TableColumn factoryCapitalColumn = new TableColumn("Kapitał zakładowy");
        factoryCapitalColumn.setCellValueFactory(new PropertyValueFactory("factoryCapital"));
        TableColumn volumeColumn = new TableColumn("Wolumen");
        volumeColumn.setCellValueFactory(new PropertyValueFactory("volume"));
        TableColumn turnoverColumn = new TableColumn("Obroty");
        turnoverColumn.setCellValueFactory(new PropertyValueFactory("turnover"));


        tableView.getColumns().addAll(nameColumn, dateColumn, minColumn, numberOfActionColumn, openingColumn, valueColumn, profitColumn, incomeColumn, ownCapitalColumn, factoryCapitalColumn, volumeColumn, turnoverColumn);
        ObservableList<Company> data = tableView.getItems();
        List<Company> list = MenuFunctionality.getCompanyList();
        for (Company company:list) {
            data.add(company);
        }

        tableView.setRowFactory( tv -> {
            TableRow<Company> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Company rowData = row.getItem();
                    if(rowData!=null){
                        MenuFunctionality.setDisplayedObject(rowData);
                        PageOpener.detailsCompany();
                    }
                }
            });
            return row ;
        });
    }

}
