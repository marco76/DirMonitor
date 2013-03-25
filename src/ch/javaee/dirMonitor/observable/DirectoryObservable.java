package ch.javaee.dirMonitor.observable;

import ch.javaee.dirMonitor.observer.DirectoryObserver;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

public interface DirectoryObservable {
    public void addObserver(DirectoryObserver observer);
    public void updateObserver(WatchEvent.Kind<Path> kind, Path path);
    public void deleteAllObservers();

}
