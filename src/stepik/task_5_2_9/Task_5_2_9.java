package stepik.task_5_2_9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Task_5_2_9 {}

class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {65, 13, 10, 10, 13});
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16);

        int currentByte = -1;
        int previosByte = -1;
        while ( (currentByte = System.in.read()) > 0) {
            if (previosByte != -1) {
                if (previosByte != 13) {
                    System.out.write(previosByte);
                    outputStream.write(previosByte);
                } else if (currentByte != 10) {
                    System.out.write(previosByte);
                    outputStream.write(previosByte);
                }
            }
            previosByte = currentByte;
        }

        if (previosByte != -1) {
            System.out.write(previosByte);
            outputStream.write(previosByte);
        }

        System.out.flush();


        System.out.println("Result: ");
        byte [] out = outputStream.toByteArray();
        for (byte b : out){
            System.out.println(b);
        }
    }
}
