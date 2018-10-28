package net.largem.poc.typedenum;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SafetyField> fields = ImmutableList.of(CaseField.NAME, CaseField.NUMBER, CaseField.LIST);

        fields.forEach(f -> {
            System.out.println(f.name());
            System.out.println(f.type());
        });
    }
}
