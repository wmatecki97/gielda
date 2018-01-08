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
        tableView.prefHeightProperty().bind(pane.heightProperty());

        TableColumn nameColumn = new TableColumn("Nazwa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn valueColumn = new TableColumn("Aktualna wartość akcji");
        valueColumn.setCellValueFactory(new PropertyValueFactory("value"));
        TableColumn profitColumn = new TableColumn("Zysk");
        profitColumn.setCellValueFactory(new PropertyValueFactory("profit"));
        TableColumn incomeColumn = new TableColumn("Przychód");
        incomeColumn.setCellValueFactory(new PropertyValueFactory("income"));
        TableColumn turnoverColumn = new TableColumn("Obroty");
        turnoverColumn.setCellValueFactory(new PropertyValueFactory("turnover"));

        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(3.5));
        valueColumn.prefWidthProperty().bind(tableView.widthProperty().divide(3.5));
        profitColumn.prefWidthProperty().bind(tableView.widthProperty().divide(7));
        incomeColumn.prefWidthProperty().bind(tableView.widthProperty().divide(7));
        turnoverColumn.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        tableView.getColumns().addAll(nameColumn, valueColumn, profitColumn, incomeColumn,  turnoverColumn);
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
                        if(MenuFunctionality.checkItemOccurance(rowData.getId())){
                            MenuFunctionality.setDisplayedObject(rowData);
                            PageOpener.detailsCompany();
                        }
                    }
                }
            });
            return row ;
        });
    }

}
