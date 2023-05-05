import com.controller.MainFormController;
import com.model.MainFormModel;
import com.model.Node;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


 class TestApplication {

    @Test
     void testingJSONParsing() throws IOException {

        MainFormModel model = new MainFormModel();
        model.setFile(new File("src/test/resources/Test.json"));
        MainFormController controller = new MainFormController(model);

        Node result = controller.getDataFromJSON(model.getFileContext());

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
