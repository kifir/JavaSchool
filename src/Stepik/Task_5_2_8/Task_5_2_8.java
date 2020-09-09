package Stepik.Task_5_2_8;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Task_5_2_8 {
    public static void main(String[] args) throws IOException {
        System.out.println("Task_5_2_8");

        InputStream stream = new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01});
        System.out.println(checkSumOfStream(stream));
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int block;
        int sum = 0;
        while ((block = inputStream.read()) > 0) {
            System.out.println((char) block);
            sum = Integer.rotateLeft(sum,1) ^ block ;
        }

        return sum;
    }
}
