package com;

import javafx.scene.control.TreeCell;

public class NodeTreeCell extends TreeCell<Node> {

    @Override
    protected void updateItem(Node item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
            setStyle("-fx-background-color: transparent;" +
                    "-fx-text-fill: white");
        } else {
            if (!item.getChildrenNodes().isEmpty()) {
                setText(item.getKeyName());
                setStyle("-fx-background-color: #015b01;" +
                        "-fx-text-fill: white");
            } else {
                if (item.getKeyName() != null && item.getValue() != null) {
                    setText(item.getKeyName() + ": " + item.getValue());
                    setStyle("-fx-text-fill: black");
                }
                if(item.getKeyName().equals("")){
                    setText(item.getValue());
                    setStyle("-fx-text-fill: black");
                }
            }
        }
    }
}
