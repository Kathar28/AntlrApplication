package com;

import com.antlr.JSONLexer;
import com.antlr.JSONParser;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainForm {
    private final Stage parentStage;

    private TreeView<Node> treeView;

    private TextArea textArea;

    private BorderPane mainContainer;

    private File file;

    public MainForm(Stage parentStage) {
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
                if (file != null) {
                    fileName.setText("Имя файла: " + file.getName());
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
                treeView.setRoot(fillTree(getDataFromJSON()));
            }
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        hBox.getChildren().addAll(fileName, spacer, loadFileButton, parseButton);
        return hBox;
    }

    private TreeItem<Node> fillTree(Node rootNode) {
        TreeItem<Node> rootTreeItem = new TreeItem<>(rootNode);
        for (Node childNode : rootNode.getChildrenNodes()) {
            rootTreeItem.getChildren().add(fillTree(childNode));
        }
        return rootTreeItem;
    }

    public TreeView<Node> createTreeView() {
        TreeView<Node> tree;
        if (file != null) {
            tree = new TreeView<>(fillTree(getDataFromJSON()));
        } else tree = new TreeView<>();
        tree.setPrefSize(450, 450);
        tree.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tree.setCellFactory(cf -> new NodeTreeCell());
        return tree;
    }

    public Node getDataFromJSON() {
        JSONLexer lexer = new JSONLexer(CharStreams.fromString(textArea.getText()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        Listener listener = new Listener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.json());
        return listener.getCurrent();
    }

    public TextArea createTextArea() {
        TextArea text = new TextArea();
        text.setPrefSize(450, 450);
        text.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return text;
    }

    private void readFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть файл");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON файлы (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        file = fileChooser.showOpenDialog(parentStage);
        if (file != null) {
            textArea.setText(new String(Files.readAllBytes(Paths.get(file.getPath()))));
        }
    }

    private void showAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
