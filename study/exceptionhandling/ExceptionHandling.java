package study.exceptionhandling;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExceptionHandling {

    public static void main(String[] args) throws IOException, ArithmeticException, IndexOutOfBoundsException {
        FileReader fr = null;
        //cannot declare outside try if we does exception cant be handled
//        divide(5,0);
        try {
            //calling the function which may cause exception inside the try
//            divide(5, 0);
            ArrayList<Integer> al = new ArrayList<>();
            //execution breaks at the first exception
            fr = new FileReader("fil.txt");
            al.get(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.fillInStackTrace());
        }
        //catching multiple exception
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        //handling the arithmetic exception
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        //finally executes irrespective of exception occurs or not (mostly for clean up operations)
        finally {
            if (fr != null) {
                fr.close();
            }
        }
    }

    public static void divide(int a, int b) {
        if (b <= 0) {
            //throwing exception manually
            throw new ArithmeticException("Denominator cant be zero");
        }
        //handling using try catch
//        try{
//           int c = a/b;
//        }
//        catch(ArithmeticException e){
//            System.out.println(e.getMessage());
//        }
    }

    //throws do not handle the exception (only try catch does) it just specify that exception may arise
//    public static void main(String[] args) throws Exception{
//            ArrayList<Integer> al = new ArrayList<>();
//            //execution breaks at the first exception
//            al.get(0);
//            FileReader fw = new FileReader("fil.txt");
//    }

}
