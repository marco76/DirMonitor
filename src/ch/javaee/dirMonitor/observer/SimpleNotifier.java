package ch.javaee.dirMonitor.observer;

import ch.javaee.dirMonitor.demo.DemoRecord;
import javafx.collections.ObservableList;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

public class SimpleNotifier implements DirectoryObserver {

    private ObservableList<DemoRecord> demoRecordList = null;


    public SimpleNotifier(ObservableList<DemoRecord> demoRecordList) {
        this.demoRecordList = demoRecordList;
    }

    @Override
    public void update(WatchEvent.Kind<Path> kind, Path path) {
        System.out.format("%s: %s\n", kind.name(), path);
        demoRecordList.add(0, new DemoRecord(kind.name(), path.toString()));
    }
}
