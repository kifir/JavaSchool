package stepik.task_6_4_12;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task_6_4_12 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,1,1,1);
        intList.forEach(System.out::println);
        Stream intStream = intList.stream();

        BiConsumer<Integer,Integer> testConsumer = (val1, val2) -> System.out.println(val1.equals(val2));
        
        Comparator<Integer> testComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        
        findMinMax(intStream, testComparator, testConsumer);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> streamList = new ArrayList(Arrays.asList(stream.toArray()));
//        System.out.println("max = " + Collections.max(streamList, order));
//        System.out.println("min = " + Collections.min(streamList, order));

        if (streamList.size() > 0) {
            minMaxConsumer.accept(Collections.min(streamList, order), Collections.max(streamList, order));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
}
