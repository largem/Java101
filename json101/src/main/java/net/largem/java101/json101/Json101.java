package net.largem.java101.json101;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public final class Json101
{
    public static void main(String[] args) throws IOException {
        System.out.println("Here starts Json101");

        Sub sub = new Sub(1,"base", 2, "sub");

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(sub);

        System.out.println(jsonString);

        //This should not work by default.
        Base base = mapper.readValue(jsonString, Base.class);

        System.out.println(base.getIntPropBase());

    }
}

