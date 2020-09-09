package School.Task_2;

import java.util.Comparator;

class SortComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length()){
            return s1.compareTo(s2);
        } else {
            return s1.length() - s2.length();
        }
    }
}
