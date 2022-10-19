import java.io.*;
import java.util.*;
public class HuffmanEncode {
    
    public String fileIn;
    public String fileOut;
    public BufferedReader br;

    public HuffmanEncode(String in, String out) {
        //Implements the main flow of your program 
        //in is the name of the source file 
        //out is the name of the output file
        //Add private methods and instance variables as needed

        fileIn = in;
        fileOut = out;


        try{
            FileReader fr = new FileReader(in);
            br = new BufferedReader(fr);
            PriorityQueue<Character> queue = createPriorityQueue(br);


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public PriorityQueue<Character> createPriorityQueue(BufferedReader br){
        
    }

    



    public static void main(String args[]) {
        //args[0] is the name of the source file 
        //args[1] is the name of the output file
        new HuffmanEncode(args[0], args[1]);
        //do not change anything here
    }
}
