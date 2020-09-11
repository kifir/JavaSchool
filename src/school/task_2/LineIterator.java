package school.task_2;

import java.util.ArrayList;
import java.util.Iterator;

public class LineIterator<T> implements Iterator<T> {
    private int currentId;
    private ArrayList<T> list;

    LineIterator(ArrayList<T> a){
        list = a;

        if (list.size() > 0) {
            currentId = list.size()-1;
        }
    }

    @Override
    public boolean hasNext() {
        return currentId >= 0;
    }

    @Override
    public T next() {
        return list.get(currentId--);
    }
}
