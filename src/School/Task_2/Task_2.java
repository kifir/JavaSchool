package School.Task_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Task_2");

        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);

        String inputFileName = "src/School/Task_2/input.txt";

        InputStream input = new FileInputStream(inputFileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        HashSet<String> distinctWords = new HashSet<>();

//        while ((line = reader.readLine()) != null){
//            System.out.println(line);
//            distinctWords.addAll(Arrays.asList(line.split(" ")));
//        }
//        System.out.println();
//        distinctWords.forEach(System.out::println);

        while ((line = reader.readLine()) != null){
            distinctWords.addAll(Arrays.asList(line.split(" ")));
        }

        System.out.println("Количество различных слов в файле " + distinctWords.size());

        ArrayList<String> listWords = new ArrayList<>(distinctWords);
        System.out.println(">>> Исходное множество слов");
        listWords.forEach(System.out::println);
        listWords.sort(new SortComparator());
        System.out.println();
        System.out.println(">>> Отсортированное множество слов");
        listWords.forEach(System.out::println);
    }
}

