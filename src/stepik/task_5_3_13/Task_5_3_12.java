package stepik.task_5_3_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task_5_3_12 {
}

class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList();

        while (input.hasNext()) {
            words.addAll(Arrays.asList(input.nextLine().split(" ")));
        }

        Double sum = 0.0;

        for (String word : words) {
            try {
                Double current = Double.parseDouble(word);
                sum += current;
            } catch (Exception e) { }
        }

        System.out.println(String.format("%.6f" , sum));
    }
}
