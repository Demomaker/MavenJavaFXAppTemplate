package net.demomaker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.InputMethodEvent;

public class SettingsController implements Initializable {
    private boolean isLanguageSettingsActive = false;
    @FXML
    private ChoiceBox languageSelector;

    public void activateLanguageSettings(ActionEvent actionEvent) {
        isLanguageSettingsActive = !isLanguageSettingsActive;
        updateVisibility();
    }

    public void updateVisibility() {
        if(isLanguageSettingsActive) {
            languageSelector.setVisible(true);
        }
        else {
            languageSelector.setVisible(false);
        }
    }

    public void changeLanguage(Event event) {
        I18N.setLanguage(languageSelector.getValue().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.languageSelector.getItems().addAll(I18N.getAvailableLanguages());
        this.languageSelector.setValue(I18N.getLanguageFromLocale(I18N.getCurrentLocale()));
        this.languageSelector.setOnAction(this::changeLanguage);
        updateVisibility();
    }
}