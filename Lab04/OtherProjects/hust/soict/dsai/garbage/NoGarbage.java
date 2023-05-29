package hust.soict.dsai.garbage;

public class NoGarbage {
    public void concatBuffer(byte[] inputBytes) {
        long startBuffer = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b: inputBytes) {
            outputStringBuffer.append((char)b);
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("Total running time for concatenation using StringBuffer:" + (endBuffer - startBuffer));
    }

    public void concatBuilder(byte[] inputBytes) {
        long startBuilder = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b: inputBytes) {
            outputStringBuilder.append((char)b);
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("Total running time for concatenation using StringBuilder:" + (endBuilder - startBuilder));
    }

}
