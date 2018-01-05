package AllObjects.GUI.DisplayTemplates;

import AllObjects.Clients.InvestmentFund;
import AllObjects.GUI.PageOpener;
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

public class InvestmentFundController implements Initializable {

    @FXML
    private TableView<InvestmentFund> tableView;

    @FXML
    private AnchorPane pane;

    public void initialize(URL location, ResourceBundle resources) {



        tableView.prefWidthProperty().bind(pane.widthProperty());



        TableColumn firstNameColumn = new TableColumn("Imię");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn surnameColumn = new TableColumn("Nazwisko");
        surnameColumn.setCellValueFactory(new PropertyValueFactory("surname"));
        TableColumn nameColumn = new TableColumn("Nazwa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn valueColumn = new TableColumn("Wartość jednostki uczestnictwa");
        valueColumn.setCellValueFactory(new PropertyValueFactory("currentValue"));

        firstNameColumn.prefWidthProperty().bind(pane.widthProperty().divide(4));
        surnameColumn.prefWidthProperty().bind(pane.widthProperty().divide(4));
        nameColumn.prefWidthProperty().bind(pane.widthProperty().divide(4));
        valueColumn.prefWidthProperty().bind(pane.widthProperty().divide(4));

        tableView.getColumns().addAll(firstNameColumn, surnameColumn, nameColumn, valueColumn);
        ObservableList<InvestmentFund> data = tableView.getItems();
        List<InvestmentFund> list = MenuFunctionality.getInvestmentFundList();
        for(InvestmentFund investmentFund: list)
            data.add(investmentFund);

        tableView.setRowFactory( tv -> {
            TableRow<InvestmentFund> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    InvestmentFund rowData = row.getItem();
                    if(rowData!=null){
                        MenuFunctionality.setDisplayedObject(rowData);
                        PageOpener.detailsInvestmentFund();
                    }
                }
            });
            return row ;
        });

    }
}
