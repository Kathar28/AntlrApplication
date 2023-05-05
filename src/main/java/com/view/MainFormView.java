package com.view;

import com.controller.MainFormController;
import com.model.MainFormModel;
import com.model.Node;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class MainFormView {
    private final Stage parentStage;

    private BorderPane mainContainer;

    private TreeView<Node> treeView;

    private TextArea textArea;

    private MainFormController controller;

    private MainFormModel model;

    public MainFormView(Stage parentStage, MainFormController controller, MainFormModel model) {
        this.controller = controller;
        this.model = model;
        drawingAllElements();
        this.parentStage = parentStage;
        Scene mainScene = new Scene(mainContainer);
        this.parentStage.setMinHeight(600);
        this.parentStage.setMinWidth(600);
        this.parentStage.setScene(mainScene);
    }

    private void drawingAllElements() {
        mainContainer = new BorderPane();
        treeView = createTreeView();
        textArea = createTextArea();
        mainContainer.setCenter(drawTreeViewAndTextArea());
        mainContainer.setTop(drawLabelAndButtons());
    }

    private HBox drawTreeViewAndTextArea() {
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hBox.setPadding(new Insets(20));
        hBox.getChildren().addAll(textArea, treeView);
        HBox.setHgrow(textArea, Priority.ALWAYS);
        HBox.setHgrow(treeView, Priority.ALWAYS);
        return hBox;
    }

    private HBox drawLabelAndButtons() {
        Label fileName;
        HBox hBox = new HBox();

        hBox.setSpacing(20);
        hBox.setPadding(new Insets(20));

        fileName = new Label("Имя файла: файл не выбран");
        Button loadFileButton = new Button("Выбрать файл");

        loadFileButton.setOnAction(actionEvent -> {
            try {
                readFile();
                if (model.getFile() != null) {
                    textArea.setText(model.getFileContext());
                    fileName.setText("Имя файла: " + model.getFile().getName());
                    treeView.setRoot(null);
                }
            } catch (IOException e) {
                showAlertMessage(e.getMessage());
            }
        });
        HBox.setHgrow(loadFileButton, Priority.ALWAYS);
        Button parseButton = new Button("Выполнить парсинг");
        parseButton.setOnAction(actionEvent -> {
            if (textArea.getText().isEmpty() || textArea.getText().equals("")) {
                showAlertMessage("В текстовом поле пусто. Введите текст или выбирите файл.");
            } else {
                try {
                    controller.updateRootNode(textArea.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                treeView.setRoot(model.getRootNode());
            }
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        hBox.getChildren().addAll(fileName, spacer, loadFileButton, parseButton);
        return hBox;
    }

    public TreeView<Node> createTreeView() {
        TreeView<Node> tree;
        tree = new TreeView<>();
        tree.setPrefSize(450, 450);
        tree.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tree.setCellFactory(cf -> new NodeTreeCell());
        return tree;
    }

    public TextArea createTextArea() {
        TextArea text = new TextArea();
        text.setPrefSize(450, 450);
        text.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return text;
    }

    public void readFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть файл");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON файлы (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        model.setFile(fileChooser.showOpenDialog(parentStage));
    }

    private void showAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
