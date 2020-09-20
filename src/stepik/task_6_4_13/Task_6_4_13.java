package stepik.task_6_4_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов. *
 * Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!"
 * ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 *
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре. *
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть. *
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите
 * слова с одинаковой частотой в лексикографическом порядке.
 *
 * Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
 */
public class Task_6_4_13 {
    public static void main(String[] args) {
        BufferedReader inBuffer = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Stream<String> inStream = inBuffer.lines();
        List<String> wordsList = new ArrayList<>();
        inStream.map(s -> s.toLowerCase().split("[\\p{Punct}\\s]+"))
                .flatMap(Arrays::stream)
//                .map(s -> s.split("-"))
//                .flatMap(Arrays::stream)
//                .map(s -> deleteBadChar(s))
//                .limit(10)
//                .sorted(String::compareTo)
                .forEach(s -> wordsList.add(s));

        Map<String, Long> wordsMap = wordsList.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        Map<String, Long> wordsSortedMap = new LinkedHashMap<>();
        wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEachOrdered(s -> wordsSortedMap.put(s.getKey(), s.getValue()));

        for (String word : wordsSortedMap.keySet()){
            System.out.println(word);
        }
    }

    public static void main2(String[] args) throws IOException {
        // Для чтения входного потока используем Scanner.
        // Поскольку словами мы считаем последовательности символов,
        // состоящие из букв или цифр, то в качестве разделителя слов Scanner'у
        // указываем регулярное выражение, означающее
        // "один или более символ, не являющийся ни буквой, ни цифрой".
        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");

        // Пройдем по всем словам входного потока и составим Map<String, Integer>,
        // где ключом является слово, преобразованное в нижний регистр,
        // а значением - частота этого слова.
        Map<String, Integer> freqMap = new HashMap<>();
        scanner.forEachRemaining(s -> freqMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));

        freqMap.entrySet().stream()                 // получим стрим пар (слово, частота)
                .sorted(descendingFrequencyOrder()) // отсортируем
                .limit(10)                          // возьмем первые 10
                .map(Map.Entry::getKey)             // из каждой пары возьмем слово
                .forEach(System.out::println);      // выведем в консоль
    }

    // Создание Comparator'а вынесено в отдельный метод, чтобы не загромождать метод main.
    private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() {
        // Нам нужен Comparator, который сначала упорядочивает пары частоте (по убыванию),
        // а затем по слову (в алфавитном порядке). Так и напишем:
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
}
