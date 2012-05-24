package org.newinstance.havis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.stage.Stage;
import org.newinstance.havis.gui.HaVisMenuBar;
import org.newinstance.havis.model.HaVisModel;

/**
 * HaVis
 *
 * @author dschmucki
 */
public class HaVis extends Application {

    private static final String APPLICATION_TITLE = "HaVis";
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 500;

    private HaVisModel model = new HaVisModel();
    private HaVisMenuBar menuBar = new HaVisMenuBar();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane pane = BorderPaneBuilder.create()
                .top(
                        menuBar.createMenuBar()
                )
                .build();

        Scene sceneRef = SceneBuilder.create()
                .width(SCENE_WIDTH)
                .height(SCENE_HEIGHT)
                .root(pane)
                .build();

        stage.setScene(sceneRef);
        stage.setTitle(APPLICATION_TITLE);
        stage.show();
    }
}
