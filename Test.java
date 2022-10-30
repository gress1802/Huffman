import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
   public static void main(String[] args) throws IOException{
      int[] x = getBitArray(3);
//      for(int i = 0; i<x.length; i++){
         System.out.println(x[7]);
//      }
   }

   public static int[] getBitArray(int number){
      assert (0 <= number && number <= 255);
      int[] bits = new int[8];
      for (int i = 7; i >=0; i--) {
          int mask = 1 << i;
          bits[7-i] = (number & mask) != 0 ? 1 : 0;
      }
      return bits;
   }
}
