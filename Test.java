import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
   public static void main(String[] args) throws IOException{
      String x = "010010";
      byte[] z = x.getBytes("UTF-8");
      for(int i = 0;i<z.length;i++){
         System.out.println(z[i]);
      }
   } 
}
