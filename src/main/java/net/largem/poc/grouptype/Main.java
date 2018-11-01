package net.largem.poc.grouptype;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ValueType<String> type = CaseType.StringType.getType();
        String name = CaseType.StringType.getName();

        System.out.println("Type:" + type);
        System.out.println("Name:" + name);

        List<CaseType> list = ImmutableList.of(CaseType.NumberType, CaseType.StringType);
        list.forEach(e -> {
            System.out.println("Type:" + e.getType());
            System.out.println("Name:" + e.getName());
        });
    }

}
