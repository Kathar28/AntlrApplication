package com;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String keyName;
    private final String value;
    private final ArrayList<Node> childrenNodes;
    private Node parentNode;

    public Node(String keyName, String value) {
        this.keyName = keyName;
        this.value = value;
        this.childrenNodes = new ArrayList<>();
        this.parentNode = null;
    }

    public void addChildrenNode(Node node) {
        node.parentNode = this;
        this.childrenNodes.add(node);
    }

    public List<Node> getChildrenNodes() {
        return childrenNodes;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getValue() {
        return value;
    }
}

