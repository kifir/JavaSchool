package stepik.task_6_2_15;

import java.util.*;

public class Task_6_2_15 {
}

class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        if (console.hasNext()) {
            List<String> words = Arrays.asList(console.nextLine().split(" "));
            List<String> resultWords = new ArrayList<>();
            for (int i = 0; i < words.size(); i++) {
                if (i % 2 == 1) {
                    resultWords.add(words.get(i));
                }
            }
            Collections.reverse(resultWords);

            resultWords.forEach(x -> System.out.print(x + " "));
        }
    }
}
