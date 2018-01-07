package AllObjects.functionalClasses;

import javafx.scene.chart.Chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChartLine implements Serializable {

    private String name;
    private int id;
    private List<Double> list;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }

    public ChartLine(int id, String name){
        this.id = id;
        this.name = name;

    }

    public List<Double> getList() {
        return list;
    }

    public void setListSize(int size){
        while(list.size()<size)
            list.add(0,-1.0);
    }

}
