package net.demomaker;

import java.util.HashMap;
import java.util.Map;

public class SceneDimensions {
  private static HashMap<String, Integer> sceneWidths = new HashMap<>(Map.of(
      "primary", 1280,
      "settings", 680
  ));
  private static HashMap<String, Integer> sceneHeights = new HashMap<>(Map.of(
      "primary", 720,
      "settings", 440
  ));

  public static Integer getCurrentSceneWidth(String sceneName) {
    return sceneWidths.get(sceneName);
  }

  public static void setCurrentSceneWidth(String sceneName, Integer currentSceneWidth) {
    if(sceneWidths.containsKey(sceneName))
      sceneWidths.replace(sceneName, currentSceneWidth);
    else
      sceneWidths.put(sceneName, currentSceneWidth);
  }

  public static Integer getCurrentSceneHeight(String sceneName) {
    return sceneHeights.get(sceneName);
  }

  public static void setCurrentSceneHeight(String sceneName, Integer currentSceneHeight) {
    if(sceneHeights.containsKey(sceneName)) {
      sceneHeights.replace(sceneName, currentSceneHeight);
    }
    else
      sceneHeights.put(sceneName, currentSceneHeight);
  }
}
