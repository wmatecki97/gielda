package AllObjects.GUI;

import AllObjects.Goods.Company;
import AllObjects.functionalClasses.AllInstancess;
import AllObjects.functionalClasses.ChartLine;
import AllObjects.functionalClasses.MenuFunctionality;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChartController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private NumberAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private LineChart<Number,Number> lineChart;

    private List<ChartLine> list;

    @FXML
    private ListView<ChartLine> listView;

    private void loadData(){

        list = MenuFunctionality.getChartIdList();

        if(list.size()>0){

            int length = 0;

            for(ChartLine line: list){ //getting the longest list
                if(length<line.getList().size())
                    length=line.getList().size();
            }

            for(ChartLine line: list){ //setting length of series
                line.setListSize(length);
            }
            for(ChartLine line: list){//adding series to chart
                series = new XYChart.Series();
                List<Double> dataList = line.getList();
                series.setName(line.getName());
                for(int i=0; i<dataList.size(); i++){
                    if(dataList.get(i)!=-1.0)
                        series.getData().add(new XYChart.Data(i, dataList.get(i)));
                }
                lineChart.getData().add(series);
            }

            ObservableList<ChartLine> data = FXCollections.observableList(list);
            listView.setItems(data);
            listView.setCellFactory(new Callback<ListView<ChartLine>, ListCell<ChartLine>>() {
                @Override
                public ListCell<ChartLine> call(ListView<ChartLine> param) {
                    ListCell<ChartLine> cell = new ListCell<ChartLine>(){

                        @Override
                        protected void updateItem(ChartLine t, boolean bln) {
                            super.updateItem(t, bln);
                            if (t != null) {
                                setText(t.getName());
                            }
                        }
                    };
                    return cell;
                }
            });
            listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    MenuFunctionality.setDisplayedObject((AllInstancess) MenuFunctionality.getGood(listView.getSelectionModel().getSelectedItem().getId()));
                    PageOpener.detailsCompany();
                }
            });
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    public XYChart.Series getSeries() {
        return series;
    }

    private XYChart.Series series;


    public void refresh(ActionEvent actionEvent) {
        lineChart.getData().clear();
        listView.getItems().clear();
        loadData();
    }

    public void addData(ActionEvent actionEvent) {
        PageOpener.companyPage();
    }
}
