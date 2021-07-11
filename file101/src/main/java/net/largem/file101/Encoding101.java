package net.largem.file101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Encoding101 {

    public static void main(String[] args) {
        Charset cs = Charset.defaultCharset();
        System.out.println("System default charset is " + cs.name());
        readEncodedFile();
    }

    private static void readEncodedFile() {

        final InputStream resourceAsStream = Encoding101.class.getResourceAsStream("/utf-16_file.txt");

        final String newLine = System.getProperty("line.separator");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream/*, StandardCharsets.UTF_16BE*/))) {
            String contents = reader.lines().collect(Collectors.joining(newLine));

            System.out.println("contains this " + contents.contains("this"));   //return false if provide wrong charsets above (for decoding)
            System.out.println(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
