package com;

import com.antlr.JSONBaseListener;
import com.antlr.JSONParser;
import com.model.Node;

public class Listener extends JSONBaseListener {

    private Node current;

    @Override
    public void enterJson(JSONParser.JsonContext ctx) {
        if(current == null){
            current = new Node("root", "");
        }
    }

    @Override
    public void enterPair(JSONParser.PairContext ctx) {
        if (ctx.value().object() != null) {
            Node node = new Node(ctx.STRING().toString(), "");
            this.current.addChildrenNode(node);
            this.current = node;
        } else {
            Node node = new Node(ctx.STRING().toString(), ctx.value().getText());
            this.current.addChildrenNode(node);
            this.current = node;
        }
    }

    @Override
    public void enterArray(JSONParser.ArrayContext ctx) {
        for (JSONParser.ValueContext valueCtx : ctx.value()) {
            handleArrayElement(valueCtx);
        }
    }

    private void handleArrayElement(JSONParser.ValueContext ctx) {
        if (ctx.array() != null) {
            enterArray(ctx.array());
        } else if (ctx.STRING() != null || ctx.NUMBER() != null) {
            Node node = new Node("", ctx.getText());
            this.current.addChildrenNode(node);
        }
    }

    @Override
    public void enterObject(JSONParser.ObjectContext ctx) {
        if (current != null && !current.getKeyName().equals("root")) {
                Node node = new Node("object", "");
                this.current.addChildrenNode(node);
                this.current = node;
        }
    }

    @Override
    public void exitObject(JSONParser.ObjectContext ctx) {
        if (!current.getKeyName().equals("root")) {
            this.current = current.getParentNode();
        }
    }

    @Override
    public void exitPair(JSONParser.PairContext ctx) {
        this.current = current.getParentNode();
    }

    public Node getCurrent() {
        return current;
    }
}


