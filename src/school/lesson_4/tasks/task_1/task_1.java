package school.lesson_4.tasks.task_1;


public class task_1 {
    public static void main(String[] args) {
        CountMapImpl<Integer> map = new CountMapImpl<>();
        map.add(1);
        map.add(1);
        map.add(2);
        map.add(6);
        map.add(6);
        map.add(6);

        int count = map.getCount(5);
       System.out.println(count);
//        System.out.println(map.remove(1));
//        System.out.println(map.remove(1));

        CountMapImpl<Integer> map2 = new CountMapImpl<>();
        map2.add(3);
        map2.add(3);
        map2.add(2);
        map2.add(3);

        System.out.println(map.size());
        map.addAll(map2);
        System.out.println(map.size());

        System.out.println(map.getCount(2));
    }
}
