package ch.javaee.dirMonitor.observer;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

public class SimpleNotifier implements DirectoryObserver {
    @Override
    public void update(WatchEvent.Kind<Path> kind, Path path) {
        System.out.format("%s: %s\n", kind.name(), path);
    }
}
