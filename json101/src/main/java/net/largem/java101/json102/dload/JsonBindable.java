package net.largem.java101.json102.dload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public interface JsonBindable {

  static String toFullJsonString(ObjectMapper om, JsonBindable o) throws JsonProcessingException {
    JsonNode node = om.valueToTree(o);
    ((ObjectNode)node).put("clazz", o.getClass().getName());
    return om.writeValueAsString(node);
  }

  static JsonBindable fromJsonString(String jsonString, ObjectMapper om)
      throws IOException, ClassNotFoundException {
    JsonNode jsonNode = om.readTree(jsonString);
    JsonNode classNode = jsonNode.findValue("clazz");
    String className = classNode.asText();
    ((ObjectNode)jsonNode).remove("clazz");

    //Class<? extends JsonBindable> clazz = (Class<? extends JsonBindable>)JsonBindable.class.getClassLoader().loadClass(className);
    Class<?> clazz = Class.forName(className);

    return om.treeToValue(jsonNode, (Class<? extends JsonBindable>)clazz);
  }
}
