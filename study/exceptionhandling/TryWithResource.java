package study.exceptionhandling;

import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) throws IOException {
        //try with resource here the resource file is automatically closed after the try block because it implements autoclosable
        try (FileReader fr = new FileReader("fil.txt")) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
