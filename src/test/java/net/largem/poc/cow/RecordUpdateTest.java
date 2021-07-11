package net.largem.poc.cow;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.math.BigDecimal;

public class RecordUpdateTest {

    @Test
    public void test() throws JsonProcessingException {
        Field<String> field1 = new FieldImpl<>("Field1", String.class);
        Field<String> field2 = new FieldImpl<>("Field2", String.class);
        Field<BigDecimal> field3 = new FieldImpl<>("Field1", BigDecimal.class);

        RecordUpdate record1 = new RecordUpdate();
        record1.setFieldValue(field1, "field1 original value");
        record1.setFieldValue(field2, "field2 original value");

        RecordUpdate record2 = new RecordUpdate(record1);
        record2.setFieldValue(field1, "updated value");
        record2.setFieldValue(field3, BigDecimal.ONE);

        record1.getFields().forEach(
                field -> System.out.println(field.getName() + ":" + field.getValue(record1.getFieldValue(field)))
        );

        record2.getFields().forEach(
                field -> System.out.println(field.getName() + ":" + field.getValue(record2.getFieldValue(field)))
        );

        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(record1));
        System.out.println(om.writeValueAsString(record2));



    }
}