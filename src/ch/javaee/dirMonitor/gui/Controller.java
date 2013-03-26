package ch.javaee.dirMonitor.gui;

import ch.javaee.dirMonitor.demo.DemoRecord;
import ch.javaee.dirMonitor.demo.DemoTableViewAdapter;
import ch.javaee.dirMonitor.observer.SimpleNotifier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.nio.file.Paths;

public class Controller {
    public Label label;
    public TextField tfDirectory;
    public Button btnMonitor;
    public TableView tvEvents;
    public ScrollPane spTable;

    public ObservableList<DemoRecord> tableDataList;

    public void monitorDirectory(ActionEvent actionEvent) {

        System.out.println("monitoring : " + tfDirectory.getText());

        try {

            final WatchDir watchDir = new WatchDir(Paths.get(tfDirectory.getText()), true);
            watchDir.addObserver(new SimpleNotifier(tableDataList));

            Task<Integer> task = new Task<Integer>() {
                @Override
                protected Integer call() throws Exception {
                    watchDir.processEvents();
                    return 0;
                }

            };

            new Thread(task).start();
            System.out.println("finished");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        //tvEvents.setVisible(false);
        tableDataList = FXCollections.observableArrayList();
        TableView<DemoRecord> tableRecord = new DemoTableViewAdapter(tableDataList);
        spTable.setContent(tableRecord);
    }


}
