package ch.javaee.dirMonitor.observer;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

public class ElpNotifier implements DirectoryObserver {

    @Override
    public void update(WatchEvent.Kind<Path> kind, Path path) {

    }
}
