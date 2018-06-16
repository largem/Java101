package net.largem.java101.json102.dload;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Sub102 sub = new Sub102("abcd", 1234);

    ObjectMapper om = new ObjectMapper();

    String jsonString = om.writeValueAsString(sub);
    System.out.println(jsonString);

    String fullJsonString = JsonBindable.toFullJsonString(om, sub);
    System.out.println(fullJsonString);

    JsonBindable o = JsonBindable.fromJsonString(fullJsonString, om);

    System.out.println(o);
  }
}
