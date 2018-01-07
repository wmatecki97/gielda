package AllObjects.GUI.DisplayTemplates;

import AllObjects.Clients.Investor;
import AllObjects.GUI.PageOpener;
import AllObjects.functionalClasses.MenuFunctionality;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InvestorController implements Initializable {

    @FXML private TableView<Investor> tableView;

	@FXML
	private AnchorPane pane;

    //@FXML private TableColumn<Investor, String>;

    public void initialize(URL location, ResourceBundle resources) {

        tableView.prefWidthProperty().bind(pane.widthProperty());

        TableColumn nameColumn = new TableColumn("Imię");
        nameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn surnameColumn = new TableColumn("Nazwisko");
        surnameColumn.setCellValueFactory(new PropertyValueFactory("surname"));
        TableColumn budgetColumn = new TableColumn("budzet");
        budgetColumn.setCellValueFactory(new PropertyValueFactory("budget"));
        TableColumn peselColumn = new TableColumn("PESEL");
        peselColumn.setCellValueFactory(new PropertyValueFactory("PESEL"));

        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        surnameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        budgetColumn.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        peselColumn.prefWidthProperty().bind(tableView.widthProperty().divide(4));
       
        tableView.getSelectionModel().getSelectedItem();

        tableView.getColumns().addAll(nameColumn, surnameColumn, budgetColumn,  peselColumn);
        ObservableList<Investor> data = tableView.getItems();
        List<Investor> list =  MenuFunctionality.getInvestorList();

        for(Investor investor: list){
            data.add(investor);
        }

        tableView.setRowFactory( tv -> {
            TableRow<Investor> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Investor rowData = row.getItem();
                    if(rowData!=null){
                        MenuFunctionality.setDisplayedObject(rowData);
                        PageOpener.detailsInvestor();
                    }
                }
            });
            return row ;
        });


    }



    public void openDetails(MouseEvent mouseEvent) {

        System.out.println("asfsaf");

    }
}
