package study.exceptionhandling;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) throws IOException {
        //try with resource here the resource file is automatically closed after the try block
        //the classes that implements the auto closable can be used in this try with resource
        try (FileReader fr = new FileReader("file.txt")) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //multiple resources in try with resources
        try (FileReader fr = new FileReader("file.txt");
             FileOutputStream fos = new FileOutputStream("file.txt")) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
