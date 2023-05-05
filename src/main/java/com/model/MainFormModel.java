package com.model;

import javafx.scene.control.TreeItem;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainFormModel {

    private TreeItem<Node> rootNode;

    private File file;

    public TreeItem<Node> getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeItem<Node> rootNode) {
        this.rootNode = rootNode;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContext() throws IOException {
        return Files.readString(Paths.get(file.getPath()), StandardCharsets.UTF_8);
    }
}
