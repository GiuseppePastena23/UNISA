import java.io.*;

public class File {
    public static void main(String[] args) {
        OutputStream os = null;
        try {
            os = new FileOutputStream("ciao.txt");

        } catch (IOException e) {

        }

    }
}
