package stepik.task_6_3_8;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Давайте научимся комбинировать функции в более сложные функции.
 * Для примера построим следующую комбинацию. Дан предикат condition и две функции ifTrue и ifFalse.
 * Напишите метод ternaryOperator, который из них построит новую функцию, возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
 *
 * Результирующая функция будет для нулевых ссылок на String возвращать 0, а для ненулевых ссылок возвращать длину строки.
 */
public class Task_6_3_8 {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply("Length"));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return x -> {
            return condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
        };
    }
}
