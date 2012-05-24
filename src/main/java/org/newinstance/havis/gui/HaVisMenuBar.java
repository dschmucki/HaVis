package org.newinstance.havis.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuBarBuilder;
import javafx.scene.control.MenuBuilder;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.input.KeyCombination;

/**
 * @author dschmucki
 */
public class HaVisMenuBar {

    public MenuBar createMenuBar() {
        return MenuBarBuilder.create()
                .menus(
                        MenuBuilder.create()
                                .text("File")
                                .items(
                                        MenuItemBuilder.create()
                                                .text("New...")
                                                .accelerator(KeyCombination.keyCombination("Ctrl+N"))
                                                .onAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent actionEvent) {
                                                        System.out.println(actionEvent.getEventType() + " occurred on MenuItem New");
                                                    }
                                                })
                                                .build(),
                                        MenuItemBuilder.create()
                                                .text("Save")
                                                .build(),
                                        MenuBuilder.create()
                                                .text("Edit")
                                                .items(
                                                        MenuItemBuilder.create()
                                                                .text("Cut")
                                                                .build(),
                                                        MenuItemBuilder.create()
                                                                .text("Paste")
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                )
                .build();
    }

}
