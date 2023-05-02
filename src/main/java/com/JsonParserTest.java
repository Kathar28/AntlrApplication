package com;

import com.antlr.JSONLexer;
import com.antlr.JSONParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class JsonParserTest {

    @Test
    public void testJsonParsing() throws IOException {
        CharStream contexFromFile = CharStreams.fromPath(Paths.get("C:\\Users\\George\\Desktop" +
                "\\Project\\AntlrApplication\\src\\main\\resources\\com\\Test.json"));
        JSONLexer lexer = new JSONLexer(contexFromFile);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        Listener listener = new Listener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.json());
        Node result = listener.getCurrent();

        assertEquals("root", result.getKeyName());
        assertEquals(3, result.getChildrenNodes().size());

        Node node1 = result.getChildrenNodes().get(0);
        assertEquals("\"name\"", node1.getKeyName());
        assertEquals("\"John\"", node1.getValue());

        Node node2 = result.getChildrenNodes().get(1);
        assertEquals("\"age\"", node2.getKeyName());
        assertEquals("30", node2.getValue());

        Node node3 = result.getChildrenNodes().get(2);
        assertEquals("\"cars\"", node3.getKeyName());
        assertEquals(2, node3.getChildrenNodes().size());

        Node node4 = node3.getChildrenNodes().get(0);
        assertEquals("\"Toyota\"", node4.getValue());

        Node node5 = node3.getChildrenNodes().get(1);
        assertEquals("\"Honda\"", node5.getValue());
    }
}
