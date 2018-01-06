package AllObjects.GUI.DisplayTemplates.DetailedView;

import AllObjects.Clients.Investor;
import AllObjects.functionalClasses.Purchase;
import AllObjects.functionalClasses.MenuFunctionality;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InvestorDetails implements Initializable{

    @FXML
    private TableView<Purchase> tableView;

    @FXML
    private AnchorPane pane;

    @FXML
    private Button deleteItem;

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;


    private Investor investor;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        investor = (Investor) MenuFunctionality.getDisplayedObject();
        MenuFunctionality.releaseDisplayedObjectSemaphore();

        l1.setText("Imię: "+investor.getFirstName());
        l2.setText("Nazwisko: " + investor.getSurname());
        l3.setText("Budżet: " + investor.getBudget());
        l4.setText("PESEL: "+ investor.getPESEL());
        l5.setText("ID: "+investor.getId());

        TableColumn nameColumn = new TableColumn("Aktywa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("subject"));
        TableColumn amountColumn = new TableColumn("Ilość");
        amountColumn.setCellValueFactory(new PropertyValueFactory("amount"));

        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(2));
        amountColumn.prefWidthProperty().bind(tableView.widthProperty().divide(2));

        tableView.getColumns().addAll(nameColumn, amountColumn);
        ObservableList<Purchase> data = tableView.getItems();
        List<Purchase> list = investor.getPurchaseList();
        for(Purchase purchase: list){
            data.add(purchase);
        }

    }

    public void deleteItem(ActionEvent actionEvent) {

        MenuFunctionality.deleteObject(investor.getId());
        Stage stage = (Stage) deleteItem.getScene().getWindow();
        stage.close();

    }
}
