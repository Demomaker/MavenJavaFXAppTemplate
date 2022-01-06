package net.demomaker;

import static net.demomaker.Window.wrapFXMLWithI18NBundlePath;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    public void openSettings() {
        Stage stage = new Stage();
        stage.setTitle(ResourceBundle.getBundle(wrapFXMLWithI18NBundlePath("primary"), I18N.getCurrentLocale()).getString("key.settings"));
        Window settingsWindow = new Window(stage, "settings");
        try {
            settingsWindow.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
