package stepik.task_5_3_11;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
 */
public class Task_5_3_11 {
    public static void main(String[] args) throws IOException {
        InputStream stream = new ByteArrayInputStream(new byte[] {48, 49, 50, 51});
        System.out.println(Task_5_3_11.readAsString(stream, StandardCharsets.US_ASCII));
    }

    /**
     * Это кривой метод. Работает не для всех тестов, т.к. при чтении кодировку не задаем.
     */
    public static String readAsString2(InputStream inputStream, Charset charset) throws IOException {
        byte[] bytes = new byte[inputStream.available()];
        int i = 0;
        int oneByte;
        while ((oneByte = inputStream.read()) > 0){
            bytes[i++] = (byte) oneByte;
        }
        return new String(bytes, charset).trim();

//        return new String(inputStream.readAllBytes(), charset);
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder resultText = new StringBuilder();
        InputStreamReader streamReader = new InputStreamReader(inputStream, charset);
        int readedInt;
        while ((readedInt = streamReader.read()) != -1){
            resultText.append((char)readedInt);
        }

        return resultText.toString();
    }
}
