package study.exceptionhandling;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NestedExceptionHandling {

    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {
        FileReader fr = null;
        try {
            ArrayList<Integer> al = new ArrayList<>();
            //nested try-catch blocks
            try {
                //exception occurs and execution moves out of the current exception handler
                fr = new FileReader("fil.txt");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            al.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fr != null) {
                fr.close();
            }
        }
    }
}
