package com;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ANTLRApplication extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("ANTLR");
        MainForm form = new MainForm(primaryStage);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}