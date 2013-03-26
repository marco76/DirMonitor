package ch.javaee.dirMonitor.demo;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DemoTableViewAdapter extends TableView <DemoRecord>{

    public DemoTableViewAdapter(ObservableList observableList) {
        super(observableList);

        TableColumn<DemoRecord, String> actionCol = new TableColumn<>("Action");
        TableColumn<DemoRecord, String> pathCol = new TableColumn<>("Path");
        actionCol.setMinWidth(100);
        pathCol.setMinWidth(300);

        actionCol.setCellValueFactory(new PropertyValueFactory<DemoRecord, String>("action"));
        pathCol.setCellValueFactory(new PropertyValueFactory<DemoRecord, String>("path"));

        //this.getColumns().add(typeCol);
        //this.getColumns().add(pathCol);
        this.getColumns().setAll(actionCol, pathCol);
    }


}
