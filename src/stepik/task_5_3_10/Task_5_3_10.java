package stepik.task_5_3_10;

import java.io.UnsupportedEncodingException;

/**
 * Задача 5.3.10
 *
 * Какими байтами представляется символ 'Ы' в кодировке UTF-8?
 * Введите десятичные беззнаковые значения байт через пробел.
 */
public class Task_5_3_10 {
    public static void main(String[] args) throws Exception {
        System.out.println("Task_5_3_10");

        String str = "Ы";
        byte [] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(((int)bytes[i] ^ -1<<8)+" ");
            System.out.println(Byte.toUnsignedInt(bytes[i]));
        }

        bytes = str.getBytes("UTF-8");
        for (byte oneByte : bytes) System.out.println(Byte.toUnsignedInt(oneByte));
    }
}


