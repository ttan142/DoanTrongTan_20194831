package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for(int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println(System.currentTimeMillis() - start);

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start);

        // Testing NoGarbage and GarbageCreator
        try {
            String fileName = "test.txt";

            byte[] inputBytes = Files.readAllBytes(Paths.get(fileName));
            GarbageCreator garbage = new GarbageCreator();
            NoGarbage noGarbage = new NoGarbage();
            garbage.concatPlusOperator(inputBytes);
            noGarbage.concatBuffer(inputBytes);
            noGarbage.concatBuilder(inputBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
