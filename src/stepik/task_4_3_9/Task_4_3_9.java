package stepik.task_4_3_9;

public class Task_4_3_9 {
    public static void main(String[] args) {
        String s = "Test find WeApons in text";
        if (s.toLowerCase().contains("weaponE")
                || s.contains("banned substance")) {
            System.out.println("Finded");
        } else {
            System.out.println("Don't find");
        }

        s = "Austin Powers" + "2";
        String s2 = "Austin Powers2";
        if (s == s2) {
            System.out.println("Nice");
        }
    }
}

