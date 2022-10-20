import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("MyFile.txt");
        try {
            fw.write("hello"+ "\n");
            fw.write("im dora"+ "\n");
        } catch (IOException e) {
            System.out.println("no such file");
        }


        fw.close();
        FileReader fr = null;
        try {
            fr = new FileReader("MyFile.txt");
        } catch (IOException e) {
            System.out.println("no such file");
        }
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        fr.close();
    }
}
