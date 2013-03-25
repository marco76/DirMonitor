package ch.javaee.dirMonitor.gui;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.nio.file.Paths;

public class Controller{
    public Label label;
    public TextField tfDirectory;
    public Button btnMonitor;

    public void monitorDirectory(ActionEvent actionEvent) {
        System.out.println("monitoring : " + tfDirectory.getText());
        try{
            final WatchDir watchDir = new WatchDir(Paths.get("/Users/marco/Downloads"), true);


                Task<Integer> task = new Task<Integer>() {
                @Override protected Integer call() throws Exception {
                    watchDir.processEvents();
                    return 0;
                }

            };

            new Thread(task).start();
            System.out.println("finished");

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
