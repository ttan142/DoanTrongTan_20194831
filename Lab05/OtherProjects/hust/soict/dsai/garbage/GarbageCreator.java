package hust.soict.dsai.garbage;

public class GarbageCreator {
    public void concatPlusOperator(byte[] inputBytes) {
        long start = System.currentTimeMillis();
        String s = "";
        for (byte b: inputBytes) {
            s += (char)b;
        }
        long end = System.currentTimeMillis();
        System.out.println("Total running time:" + (end - start));
    }

}
