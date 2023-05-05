package com.controller;

import com.Listener;
import com.antlr.JSONLexer;
import com.antlr.JSONParser;
import com.model.MainFormModel;
import com.model.Node;
import javafx.scene.control.TreeItem;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class MainFormController {

    private final MainFormModel model;

    public MainFormController(MainFormModel model){
        this.model = model;
    }

    public void updateRootNode(String text) throws IOException {
        model.setRootNode(fillTree(getDataFromJSON(text)));
    }

    public Node getDataFromJSON(String text){
        JSONLexer lexer = new JSONLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        Listener listener = new Listener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.json());
        return listener.getCurrent();
    }

    public TreeItem<Node> fillTree(Node rootNode) {
        TreeItem<Node> rootTreeItem = new TreeItem<>(rootNode);
        for (Node childNode : rootNode.getChildrenNodes()) {
            rootTreeItem.getChildren().add(fillTree(childNode));
        }
        return rootTreeItem;
    }


}
