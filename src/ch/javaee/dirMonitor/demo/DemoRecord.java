package ch.javaee.dirMonitor.demo;

import javafx.beans.property.SimpleStringProperty;

public class DemoRecord {

    private SimpleStringProperty action = new SimpleStringProperty(this, "action");
    private SimpleStringProperty path = new SimpleStringProperty(this, "path");

    public DemoRecord(String action, String path) {

        actionProperty().set(action);
        pathProperty().set(path);

    }

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }
}
