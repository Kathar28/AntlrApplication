package com;

import com.controller.MainFormController;
import com.model.MainFormModel;
import com.view.MainFormView;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ANTLRApplication extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("ANTLR");
        MainFormModel model = new MainFormModel();
        MainFormController controller = new MainFormController(model);
        MainFormView view = new MainFormView(primaryStage, controller, model);
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