package net.largem.iostream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class InputStreamStudy {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream("ABCD".getBytes(StandardCharsets.UTF_8));

        inputStream.mark(0);

        byte[] b = new byte[10];
        int ret = inputStream.read(b);
        System.out.printf("ret=%d, %s%n", ret, new String(b, StandardCharsets.UTF_8));
        ret = inputStream.read(b);
        System.out.printf("ret=%d%n", ret);
        inputStream.reset();
        ret = inputStream.read(b);
        System.out.printf("ret=%d%n", ret);
    }

}
