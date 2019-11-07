package net.largem.codewar.kata.string;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/56baeae7022c16dd7400086e
 * John keeps a backup of his old personal phone book as a text file. On each line of the file he can find the phone number (formated as +X-abc-def-ghij where X stands for one or two digits), the corresponding name between < and > and the address.
 *
 * Unfortunately everything is mixed, things are not always in the same order; parts of lines are cluttered with non-alpha-numeric characters (except inside phone number and name).
 *
 * Examples of John's phone book lines:
 *
 * "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
 *
 * " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
 *
 * "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
 *
 * Could you help John with a program that, given the lines of his phone book and a phone number returns a string for this number : "Phone => num, Name => name, Address => adress"
 *
 * Examples:
 *
 * s = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
 *
 * phone(s, "1-541-754-3010") should return "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St."
 * It can happen that, for a few phone numbers, there are many people for a phone number -say nb- , then
 *
 * return : "Error => Too many people: nb"
 *
 * or it can happen that the number nb is not in the phone book, in that case
 *
 * return: "Error => Not found: nb"
 */
public class PhoneBook {
    public static void main(String[] args) {
        String dr = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
                + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
                + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
                + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
                + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
                + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
                + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
                + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
                + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
                + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
                + "<P Salinge> Main Street, +1-098-512-2222, Denve\n"+ "<P Salinge> Main Street, +1-098-512-2222, Denve\n";

        System.out.println(phone(dr, "48-421-674-8974"));
        System.out.println(phone(dr, "1-921-512-2222"));
        System.out.println(phone(dr, "1-908-512-2222"));
        System.out.println(phone(dr, "1-541-754-3010"));
    }

    private static String phone(String strng, String num) {
        String[] entries = strng.split("\n");

        String numToMatch = num.startsWith("+") ? num : "+" + num;

        List<String> matchedEntries  = Arrays.stream(entries)
                .filter(e -> e.contains(numToMatch))
                .collect(Collectors.toList());

        if (matchedEntries.isEmpty()) {
            return "Error => Not found: "+ num;
        }

        if (matchedEntries.size() > 1) {
            return "Error => Too many people: "+ num;
        }

        final String phoneNumberRegex = "[^ ]?\\+(\\d{1,2}-\\d{3}-\\d{3}-\\d{4})[^ ]?";
        final String nameRegex = "<(.*)>";

        String matchedEntry = matchedEntries.get(0);
        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(matchedEntry);
        String name = nameMatcher.group(1);
        String address = matchedEntry.replaceAll(phoneNumberRegex,"").replaceAll(nameRegex, "");

        return String.format("Phone => %s, Name => %s, Address => %s", num, name, address);
    }
}