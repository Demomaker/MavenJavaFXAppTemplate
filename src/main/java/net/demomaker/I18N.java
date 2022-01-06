package net.demomaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class I18N {

  private static List<I18NListener> listeners = new ArrayList<>();
  private static Locale defaultLocale = Locale.ENGLISH;
  private static Locale currentLocale = defaultLocale;
  private static Map<Locale, String> availableLocalesAndLanguages = Map.of(
      Locale.ENGLISH, "English",
      Locale.CANADA_FRENCH, "Français",
      Locale.GERMAN, "Deustche");

  public static Locale getCurrentLocale() {
    return currentLocale;
  }

  public static List<Locale> getAvailableLocales() {
    return new ArrayList<>(availableLocalesAndLanguages.keySet());
  }

  public static List<String> getAvailableLanguages() {
    return new ArrayList<>(availableLocalesAndLanguages.values());
  }

  public static void setLanguage(String language) {
    setCurrentLocale(getLocaleFromLanguage(language));
  }

  private static Locale getLocaleFromLanguage(String language) {
    for(Entry<Locale, String> entry : availableLocalesAndLanguages.entrySet()) {
      if(Objects.equals(language, entry.getValue())) {
        return entry.getKey();
      }
    }
    return Locale.CANADA_FRENCH;
  }

  public static String getLanguageFromLocale(Locale locale) {
    return availableLocalesAndLanguages.get(locale);
  }

  public static void setCurrentLocale(Locale locale) {
    I18N.currentLocale = locale;
    for(I18NListener listener : listeners) {
      listener.onLocaleChange();
    }
  }

  public abstract static class I18NListener {
    I18NListener() {
      listeners.add(this);
    }

    abstract void onLocaleChange();
  }

}
