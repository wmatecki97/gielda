package AllObjects.GUI.DisplayTemplates;

import AllObjects.Clients.Investor;
import AllObjects.GUI.PageOpener;
import AllObjects.Goods.Goods;
import AllObjects.Goods.RawMaterials;
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
        TableColumn valueColumn = new TableColumn("Wartość");
        valueColumn.setCellValueFactory(new PropertyValueFactory("value"));

        nameColumn.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        unitColumn.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        valueColumn.prefWidthProperty().bind(tableView.widthProperty().divide(3));


        tableView.getColumns().addAll(nameColumn, unitColumn, valueColumn);
        ObservableList<RawMaterials> data = tableView.getItems();
        List<Goods> list = MenuFunctionality.getRawMaterialList();
        for(Goods good: list){
            data.add((RawMaterials) good);
        }

        tableView.setRowFactory( tv -> {
            TableRow<RawMaterials> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    RawMaterials rowData = row.getItem();
                    if(rowData!=null){
                        MenuFunctionality.setDisplayedObject(rowData);
                        PageOpener.detailsRawMaterial();
                    }
                }
            });
            return row ;
        });

    }
}
