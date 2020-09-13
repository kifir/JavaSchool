package school.lesson_4.examples;

import java.util.ArrayList;
import java.util.List;

public class GenericsExamples2 {
    public static void main(String[] args) {
        //List of apples
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());

        //We can assign a list of apples to a basket of apples
        List<? super Apple> basket = apples;

        basket.add(new Apple());      //Successful
        basket.add(new AsianApple()); //Successful
//        basket.add(new Fruit());      //Compile time error

        basket.forEach(System.out::println);
    }
}
