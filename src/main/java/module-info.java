module net.demomaker {
    requires javafx.controls;
    requires javafx.fxml;

    opens net.demomaker to javafx.fxml;
    exports net.demomaker;
}
