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
        this.childrenNodes.add(node);
        node.setParentNode(this);
    }

    public List<Node> getChildrenNodes() {
        return childrenNodes;
    }

    public Node getParentNode() {
        return parentNode;
    }

    private void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getValue() {
        return value;
    }

    public boolean isLeaf() {
        return childrenNodes.isEmpty();
    }

    public boolean isRoot() {
        return parentNode == null;
    }
}

