package school.lesson_2;

import java.io.*;
import java.util.*;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Task_2");

        //все с учетом регистра

        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);

        String inputFileName = "src/School/Task_2/input.txt";

        InputStream input = new FileInputStream(inputFileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        ArrayList<String> allWords = new ArrayList<>();
        ArrayList<String> allLines = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            allLines.add(line);
            allWords.addAll(Arrays.asList(line.split(" ")));
        }

        reader.close();

//        allLines = (ArrayList<String>) Files.readAllLines(Paths.get(inputFileName), StandardCharsets.UTF_8);

        HashSet<String> setWords = new HashSet<>(allWords);
        ArrayList<String> listWords = new ArrayList<>(setWords);

        //1) Подсчитайте количество различных слов в файле.
        System.out.println("Количество различных слов в файле " + setWords.size());
        //2) Выведите на экран список различных слов файла, отсортированный по возрастанию их
        //длины (компаратор сначала по длине слова, потом по тексту).
        System.out.println(">>> Исходное множество слов");
        listWords.forEach(System.out::println);
        listWords.sort(new SortComparator());
        System.out.println();
        System.out.println(">>> Отсортированное множество слов");
        listWords.forEach(System.out::println);
        //3) Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        System.out.println(">>> Вхождение слов");
        HashMap<String, Integer> mapWords = new HashMap<>();
        for (String word : allWords) {
            if (mapWords.containsKey(word)) {
                mapWords.put(word, mapWords.get(word) + 1);
            } else {
                mapWords.put(word, 1);
            }
        }

        for (String word : mapWords.keySet()) {
            System.out.println(word + " встречается " + mapWords.get(word) + " раз");
        }
        //4) Выведите на экран все строки файла в обратном порядке.
        System.out.println(">>> Строки файла в обратном порядке");
        Collections.reverse(allLines);
        allLines.forEach(System.out::println);
        Collections.reverse(allLines);
        //5) Реализуйте свой Iterator для обхода списка в обратном порядке.
        System.out.println(">>> Через итератор");
        LineIterator<String> itr = new LineIterator<>(allLines);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //6)Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        Scanner console = new Scanner(System.in);
        System.out.println(">>> Введите номера строк для вывода на экран:");
        String[] lineNumbers = console.nextLine().split(" ");
        for (String n : lineNumbers) {
            int num = Integer.parseInt(n)-1;
            if (num < allLines.size()) {
                System.out.println(allLines.get(num));
            }
        }



//        ArrayList<Car> carList = new ArrayList(
//                new Car("Hyndai", "sedan"),
//                new Car("Hyndai", "hatchback"),
//                new Car("Mazda", "sedan")
//        );
    }
}

