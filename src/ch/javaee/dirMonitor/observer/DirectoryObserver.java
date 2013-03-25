package ch.javaee.dirMonitor.observer;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

public interface DirectoryObserver {
    public void update(WatchEvent.Kind<Path> kind, Path path);
}
