module sprint_1.app {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens sprint_1.app to javafx.fxml;
    exports sprint_1.app;
}
