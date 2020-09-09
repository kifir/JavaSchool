package Stepik.Task_6_2_14;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Task_6_2_14 {
    public static void main(String[] args){
        System.out.println("Task_6_2_14");

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        s1.add(1);
        s1.add(2);
        s1.add(3);

        s2.add(1);
        s2.add(3);
        s2.add(5);

        Set<Integer> res = symmetricDifference(s1,s2);
        res.forEach(System.out::println);

        System.out.println();

        Set<Integer> res2 = symmetricDifference2(s1,s2);
        res2.forEach(System.out::println);

        System.out.println();

        Set<Integer> res3 = symmetricDifference3(s1,s2);
        res3.forEach(System.out::println);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();
        for (T s1 : set1){
            if (!set2.contains(s1)) {
                result.add(s1);
            }
        }

        for (T s2 : set2){
            if (!set1.contains(s2)) {
                result.add(s2);
            }
        }

        return result;
    }

    public static <T> Set<T> symmetricDifference2(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> answer = new HashSet<>(set1);
        Set<T> help = new HashSet<>(set2);
        answer.removeIf(help::remove);
        answer.addAll(help);
        return answer;
    }

    public static <T> Set<T> symmetricDifference3(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();
        set1.forEach(x -> {if (!set2.contains(x)) result.add(x);});
        set2.forEach(x -> {if (!set1.contains(x)) result.add(x);});

        return result;
    }
}
