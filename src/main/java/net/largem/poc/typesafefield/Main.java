package net.largem.poc.typesafefield;

import com.google.common.collect.ImmutableList;
import net.largem.poc.typesafefield.FieldConstants.CaseField;
import net.largem.poc.typesafefield.FieldConstants.RecordField;

public class Main {

    public static void main(String[] args) {
        ImmutableList<ObjectField> fields = ImmutableList.of(RecordField.ID, CaseField.STRING_FIELD, CaseField.NUMBER_FIELD);

        fields.forEach(caseField -> {
            System.out.println(caseField.getName());
            System.out.println(caseField.getType());
        });
    }
}
