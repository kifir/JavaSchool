import java.io.File;
import java.io.IOException;

public class task_5_1_7 {
    public static void main(String[] args) throws IOException {
        File[] paths;
        paths = new File[]{
                new File("a\\b\\c\\file.txt"),
                new File("a\\.\\b\\..\\c\\.\\file.txt"),
                new File(".\\a\\b\\..\\b\\c\\.\\file.txt"),
                new File("a\\..\\b\\c\\file.txt"),
                new File("a\\b\\..\\file.txt")
        };

        for (File p : paths){
            System.out.println(p.getPath() + " <=> " + p.getCanonicalPath());
        }
    }
}
