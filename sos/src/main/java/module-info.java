module game.app {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens game.app to javafx.fxml;
    exports game.app;

    opens sprint_0.product to javafx.fxml;
    exports sprint_0.product;
}
