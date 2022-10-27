import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
   public static void main(String[] args) throws IOException{
    byte x = 0;
    int z = ((x<<1) + '1' - '0');
    System.out.println(z);
    z = ((z<<1) + '1' - '0');
    System.out.println(z);
   } 
}
