package net.demomaker;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.demomaker.I18N.I18NListener;

public class Window {

  private static final String FXML_FILE_EXTENSION = ".fxml";
  private Scene scene;
  private final Stage stage;
  private String currentFXML;

  public Window(Stage stage, String fxml) {
    this.stage = stage;
    this.currentFXML = fxml;
  }

  private I18NListener i18NListener = new I18NListener() {
    @Override
    void onLocaleChange() {
      try {
        reload();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  };

  private Parent loadFXML(String fxml) throws IOException {
    currentFXML = fxml;
    return loadCurrentFXMLWithLocale(I18N.getCurrentLocale());
  }

  private Parent loadCurrentFXMLWithLocale(Locale locale) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(currentFXML + FXML_FILE_EXTENSION));
    fxmlLoader.setResources(
        ResourceBundle.getBundle(wrapFXMLWithI18NBundlePath(currentFXML), locale));
    return fxmlLoader.load();
  }

  public void load() throws IOException {
    scene = new Scene(loadFXML(currentFXML), SceneDimensions.getCurrentSceneWidth(currentFXML), SceneDimensions
        .getCurrentSceneHeight(currentFXML));
    stage.setScene(scene);
    stage.show();
  }

  public void reload() throws IOException {
    if(scene != null) {
      SceneDimensions.setCurrentSceneWidth(currentFXML, (int) scene.getWidth());
      SceneDimensions.setCurrentSceneHeight(currentFXML, (int) scene.getHeight());
    }
    load();
  }

  public static String wrapFXMLWithI18NBundlePath(String fxml) {
    return "net.demomaker." + fxml + "Scene_i18n";
  }
}
