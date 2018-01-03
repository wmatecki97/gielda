package AllObjects.GUI.DisplayTemplates;

import AllObjects.Clients.Investor;
import functionalClasses.MenuFunctionality;
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
       

        tableView.getColumns().addAll(nameColumn, surnameColumn, budgetColumn,  peselColumn);
        ObservableList<Investor> data = tableView.getItems();
        List<Investor> list =  MenuFunctionality.getInvestorList();
        for(int i=-0; i<list.size(); i++){
            data.add((Investor)list.get(i));
        }



    }

}
