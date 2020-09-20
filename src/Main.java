import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main!");

        class A { String a = "a"; }
        List<A> in = Arrays.asList(new A());
        in.stream().forEach(a -> System.out.println(a.a));
        Stream<A> st = in.stream().peek(a -> a.a = "b");
        st.forEach(a -> System.out.println(a.a));
        in.stream().forEach(a -> System.out.println(a.a));
    }
}
