package school.lesson_4.tasks.task_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Параметризовать CountMap (из репозитория выше) и реализовать его.
 */
public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> map;

    CountMapImpl(){
        map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        if (!map.containsKey(o)) {
            map.put(o, 1);
        } else {
            map.put(o, map.get(o) + 1);
        }
    }

    @Override
    public int getCount(T o) {
        return map.getOrDefault(o, 0);
    }

    @Override
    public int remove(T o) {
        if (!map.containsKey(o)) {
            return 0;
        } else {
            return map.remove(o);
        }
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (T key : source.toMap().keySet()) {
            add(key);
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        for (T key : map.keySet()) {
            destination.put(key, map.get(key));
        }
    }
}
