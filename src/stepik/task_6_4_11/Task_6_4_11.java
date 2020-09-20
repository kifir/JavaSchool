package stepik.task_6_4_11;

import java.util.stream.IntStream;

public class Task_6_4_11 {
    public static void main(String[] args) {
//        System.out.println(mid(13));
        pseudoRandomStream(13).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> mid(x*x));
    }

    public static int mid(int x){
        String xString = String.valueOf(x);
        if (xString.length() > 1) {
            return Integer.valueOf(xString.substring(xString.length()-4 > 0 ? xString.length()-4 : 0 ,xString.length()-1));
        } else {
            return 0;
        }
    }

    public static IntStream pseudoRandomStream2(int seed) {
        return IntStream.iterate(seed, n -> (n * n / 10) % 1000);
    }
}
