module sprint_0.app {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens sprint_0.app to javafx.fxml;
    exports sprint_0.app;
}
