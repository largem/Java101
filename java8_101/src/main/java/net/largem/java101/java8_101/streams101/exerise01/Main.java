package net.largem.java101.java8_101.streams101.exerise01;

/**
 * Created by James Tan on 11/13/2016.
 */

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.stream.Collectors;

/**
 * exerise01 is to use stream to convert a list to map
 */
public class Main {

    public static void main(String[] args) {
        final ImmutableList<Cell> cells = ImmutableList.of(
                new Cell("Field Name", 0),
                new Cell("Field Type", 1),
                new Cell("Data Type", 2)
        );

        final ImmutableMap<String, FieldType> fieldMapping = ImmutableMap.of(
                "Field Name", FieldType.FieldName,
                "Field Type", FieldType.FieldType,
                "Data Type", FieldType.DataType
        );

        final ImmutableMap<FieldType, Integer> typeIndices = ImmutableMap.copyOf(
                cells.stream()
                        .collect(Collectors.toMap(c -> fieldMapping.get(c.getName()), Cell::getIndex))
        );

        System.out.println(typeIndices);
    }
}
