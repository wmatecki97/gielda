package AllObjects.GUI.DisplayTemplates;

import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
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

public class RawMaterialController implements Initializable {
    @FXML
    private TableView<RawMaterials> tableView;

	@FXML
	private AnchorPane pane;


    public void initialize(URL location, ResourceBundle resources) {

        tableView.prefWidthProperty().bind(pane.widthProperty());
        tableView.prefHeightProperty().bind(pane.heightProperty());


        TableColumn nameColumn = new TableColumn("Nazwa");
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn unitColumn = new TableColumn("Jednostka");
        unitColumn.setCellValueFactory(new PropertyValueFactory("unit"));
        TableColumn currencyColumn = new TableColumn("Waluta");
        currencyColumn.setCellValueFactory(new PropertyValueFactory("currency"));
        TableColumn valueColumn = new TableColumn("Wartość");
        valueColumn.setCellValueFactory(new PropertyValueFactory("value"));
        TableColumn minColumn = new TableColumn("Min");
        minColumn.setCellValueFactory(new PropertyValueFactory("min"));
        TableColumn maxColumn = new TableColumn("Max");
        maxColumn.setCellValueFactory(new PropertyValueFactory("max"));

        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        unitColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        currencyColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        valueColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        minColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        maxColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));


        tableView.getColumns().addAll(nameColumn, unitColumn, currencyColumn, valueColumn, minColumn, maxColumn);
        ObservableList<RawMaterials> data = tableView.getItems();
        List<Goods> list = MenuFunctionality.getRawMaterialList();
        for(Goods good: list){
            data.add((RawMaterials) good);
        }

    }
}
