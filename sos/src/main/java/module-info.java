module sprint_0.app {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens sprint_0.app to javafx.fxml, javafx.controls;
    exports sprint_0.app;
}
