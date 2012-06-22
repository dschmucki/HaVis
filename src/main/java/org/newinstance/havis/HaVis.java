package org.newinstance.havis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.stage.Stage;
import org.newinstance.havis.gui.HaVisMenuBar;
import org.newinstance.havis.model.BP;
import org.newinstance.havis.model.HaVisModel;
import org.newinstance.havis.model.HaVisParser;
import org.newinstance.havis.model.Kante;

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
    private HaVisParser parser = new HaVisParser();

    private HaVisMenuBar menuBar = new HaVisMenuBar();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        parser.setModel(model);
        parser.parseBp("");
        parser.parseKoordinaten("");
        parser.parseKanten("");

        for (BP bp : model.getAllBp()) {
            System.out.println(bp.toString());
        }

        for (Kante k : model.getAllKante()) {
            System.out.println(k.toString());
        }

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

        pane.getChildren().addAll(model.getAllBp());

        stage.setScene(sceneRef);
        stage.setTitle(APPLICATION_TITLE);
        stage.show();


    }
}
