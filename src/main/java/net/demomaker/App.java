package net.demomaker;

import static net.demomaker.Window.wrapFXMLWithI18NBundlePath;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import net.demomaker.I18N.I18NListener;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        String mainScene = "primary";
        stage.setTitle(ResourceBundle.getBundle(wrapFXMLWithI18NBundlePath("primary"), I18N.getCurrentLocale()).getString("key.title"));
        Window mainWindow = new Window(stage, mainScene);
        mainWindow.load();
    }

    public static void main(String[] args) {
        launch();
    }

}