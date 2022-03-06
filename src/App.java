import java.io.BufferedWriter;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        Exhaustive_Search ex = new Exhaustive_Search();
        FileWriter out = new FileWriter("out.txt");
        StringBuilder sb = new StringBuilder("New run: ");
        boolean[][] map = new boolean[8][8];
        ex.search(0, 0, 0, 0, sb, map, null, new BufferedWriter(out));
    }
}
