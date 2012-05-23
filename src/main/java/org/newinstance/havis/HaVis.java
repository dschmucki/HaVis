package org.newinstance.havis;

import javafx.application.Application;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.stage.Stage;

/**
 * HaVis
 *
 * @author dschmucki
 */
public class HaVis extends Application {

    private static final String APPLICATION_TITLE = "HaVis";
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 500;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene sceneRef = SceneBuilder.create()
                .width(SCENE_WIDTH)
                .height(SCENE_HEIGHT)
                .root(GroupBuilder.create().build())
                .build();
        stage.setScene(sceneRef);
        stage.setTitle(APPLICATION_TITLE);
        stage.show();
    }
}
