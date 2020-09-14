package stepik.task_6_3_6;

import java.util.function.*;

public class Task_6_3_6 {
    public static void main(String[] args) {
        ObjDoubleConsumer odc = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        odc.accept(3, 4);

        DoubleUnaryOperator square = x -> x * x;
        Consumer printer = System.out::println;

        printer.accept(square.applyAsDouble(5));
    }
}
