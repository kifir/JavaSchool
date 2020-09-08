package Stepik.Task_6_1_12;

import java.util.Objects;
import java.util.Optional;

class Pair<T1,T2> {
    private T1 first;
    private T2 second;

    public T1 getFirst(){
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public Pair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    public boolean equals(Pair p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;

        return Objects.equals(first, p.first) && Objects.equals(second, p.second);
    }

    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static <T1,T2> Pair<T1,T2> of(T1 first, T2 second){
        return new Pair<>(first, second);
    }
}
